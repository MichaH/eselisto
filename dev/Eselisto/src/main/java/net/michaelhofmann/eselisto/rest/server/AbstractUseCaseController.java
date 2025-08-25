/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.eselisto.rest.server;

import net.michaelhofmann.eselisto.db.store.EselDatabase;
import net.michaelhofmann.eselisto.rest.requests.MultiValidator;
import org.apache.commons.configuration2.Configuration;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class AbstractUseCaseController {

    protected final Configuration config;
    protected final EselDatabase data;
    protected final MultiValidator validator;

    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/

    public AbstractUseCaseController(Configuration config, EselDatabase data,
            MultiValidator validator) {
        this.config = config;
        this.data = data;
        this.validator = validator;
    }

    /* ************************************************************************
        M i s c
     **************************************************************************/
    


    /* ************************************************************************
        G e t t e r  und  S e t t e r
     **************************************************************************/



}
