/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.rest.server;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import java.util.Optional;
import net.michaelhofmann.eselisto.db.entity.User;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.db.store.memory.UserRepo;
import net.michaelhofmann.eselisto.rest.requests.CreateUserRequest;
import net.michaelhofmann.eselisto.rest.response.ApiVersion;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class ApiController {
    
    private final EselDatabase data = UserRepo.getInstance();
    
    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/
    
    public ApiController() {
    }
    
    /* ************************************************************************
        M i s c
     **************************************************************************/
   
    public void registerRoutes(Javalin app) {
        app.get("/api/version", ctx -> getVersion(ctx));
        // Users
        app.get("/api/production/users/{userId}", ctx -> getUserById(ctx));
        app.post("/api/production/users", ctx -> createUser(ctx));
    }

    private void getVersion(Context ctx) {
        // ctx.contentType("application/json");
        ctx.json(new ApiVersion("0.1"));
    }

    private void createUser(Context ctx) {
        // JSON-Payload parsen
        CreateUserRequest request = ctx.bodyAsClass(CreateUserRequest.class);

        if (request.userName() == null || request.userName().isBlank()) {
            ctx.status(HttpStatus.BAD_REQUEST).result("userName is required");
            return;
        }

        User newUser = data.createUser(request.userName(), request.surrogateKey());
        ctx.status(HttpStatus.CREATED).json(newUser);
    }
    
    private void getUserById(Context ctx) {
        String userId = ctx.pathParam("userId");
        Optional<User> optUser = data.getUserById(userId);
        if (optUser.isEmpty()) {
            ctx.status(HttpStatus.NOT_FOUND).result("User not found");
        } else {
            ctx.json(optUser.get());
        }
    }
    
    /* ************************************************************************
        G e t t e r  und  S e t t e r
     **************************************************************************/

}
