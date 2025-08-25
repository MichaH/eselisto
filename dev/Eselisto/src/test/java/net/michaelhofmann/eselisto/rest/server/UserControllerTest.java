/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.rest.server;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import io.javalin.Javalin;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.rest.requests.MultiValidator;
import org.apache.commons.configuration2.Configuration;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.testtools.JavalinTest;
import net.michaelhofmann.eselisto.db.entity.User;
import net.michaelhofmann.eselisto.db.store.memory.UserRepo;
import net.michaelhofmann.eselisto.rest.requests.RequestCreateUser;
import org.apache.commons.configuration2.BaseConfiguration;

/**
 *
 * @author michael
 */
public class UserControllerTest {
    
    private Configuration config;
    private EselDatabase data;
    private MultiValidator validator;
    private Javalin app;
    private ApiController apiController;

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public UserControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        config = new BaseConfiguration();
        data = UserRepo.getInstance();
        validator = new MultiValidator();    
        
        app = Javalin.create();
        apiController = new ApiController(config, data, validator);
        apiController.registerRoutes(app);
        app.before(ctx -> ctx.contentType("application/json"));        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /*  ***********************************************************************
     *  T e s t
     **************************************************************************/
    @Test
    void testCreateAndFetchUser() {

        JavalinTest.test(app, (server, client) -> {

            var request = new RequestCreateUser("integrationUser", "SK-123");
            String jsonPayload = objectMapper.writeValueAsString(request);
            
            var postResponse = client.post("/api/production/users", jsonPayload);
            assertEquals(201, postResponse.code());
            var responseAsString = client.post("/api/production/users", jsonPayload).body().string();
            
            User createdUser = objectMapper.readValue(responseAsString, User.class);
            assertEquals("integrationUser", createdUser.getUserName());
            assertEquals("SK-123", createdUser.getSurrogateKey());
            assertNotNull(createdUser.getUserId());

            // GET /users/{id}
            var getResponse = client.get("/api/production/users/" + createdUser.getUserId());
            assertEquals(200, getResponse.code());

            User selectedUser = objectMapper.readValue(responseAsString, User.class);
            assertEquals("integrationUser", selectedUser.getUserName());
            assertEquals("SK-123", selectedUser.getSurrogateKey());
            assertEquals(createdUser.getUserId(), selectedUser.getUserId());
        });
    }
}
