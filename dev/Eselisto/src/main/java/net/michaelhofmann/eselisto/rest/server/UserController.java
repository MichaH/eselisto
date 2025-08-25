/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.eselisto.rest.server;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import java.util.Optional;
import net.michaelhofmann.eselisto.db.entity.User;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.rest.requests.MultiValidator;
import net.michaelhofmann.eselisto.rest.requests.RequestCreateUser;
import org.apache.commons.configuration2.Configuration;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class UserController extends AbstractUseCaseController {

    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/

    public UserController(Configuration config, EselDatabase data,
            MultiValidator validator) {
        super(config, data, validator);
    }

    /* ************************************************************************
        M i s c
     **************************************************************************/
    
    public void createUser(Context ctx) {
        // JSON-Payload parsen
        RequestCreateUser request = ctx.bodyAsClass(RequestCreateUser.class);

        try {
            validator.validate(request);
        } catch (IllegalArgumentException e) {
            ctx.status(HttpStatus.BAD_REQUEST).result(e.getMessage());
            return;
        }

        User newUser = data.createUser(request.getUserName(), request.getSurrogateKey());
        ctx.status(HttpStatus.CREATED).json(newUser);
    }

    public void getUserById(Context ctx) {
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
