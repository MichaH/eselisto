/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.eselisto.rest.server;

import io.javalin.http.Context;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.rest.requests.MultiValidator;
import net.michaelhofmann.eselisto.rest.response.ApiVersion;
import org.apache.commons.configuration2.Configuration;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class InfoController extends AbstractUseCaseController {

    
    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/

    public InfoController(Configuration config, EselDatabase data,
            MultiValidator validator) {
        super(config, data, validator);
    }

    /* ************************************************************************
        M i s c
     **************************************************************************/
    
    public void getVersion(Context ctx) {
        ctx.json(new ApiVersion("0.1"));
    }

    /* ************************************************************************
        G e t t e r  und  S e t t e r
     **************************************************************************/


}
