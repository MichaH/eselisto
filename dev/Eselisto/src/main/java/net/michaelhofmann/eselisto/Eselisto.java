/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto;

import io.javalin.Javalin;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.db.store.memory.UserRepo;
import net.michaelhofmann.eselisto.rest.requests.MultiValidator;
import net.michaelhofmann.eselisto.rest.server.ApiController;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;

/**
 *
 * @author michael
 */
public class Eselisto {

    public static void main(String[] args) {
        
        Configuration config = new BaseConfiguration();
        EselDatabase data = UserRepo.getInstance();
        MultiValidator validator = new MultiValidator();
    

        // WebServer starten
        Javalin app = Javalin.create(); // keine defaultContentType-Einstellung
        ApiController apiController = new ApiController(config, data, validator);
        apiController.registerRoutes(app);
        app.before(ctx -> ctx.contentType("application/json"));
        app.start(7000);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }        
        
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:7000/api/version"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Antwort von /api/version:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.err.println("Fehler beim internen API-Request:");
            e.printStackTrace();
        }        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }        
        
        
    }
}
