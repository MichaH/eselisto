/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.eselisto.rest.requests;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class MultiValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/

    public MultiValidator() {
    }
    
    /* ************************************************************************
        M i s c
     **************************************************************************/
    
    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if ( ! violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> violation : violations) {
                sb.append(violation.getPropertyPath())
                  .append(": ")
                  .append(violation.getMessage())
                  .append("; ");
            }
            throw new IllegalArgumentException("Validation failed: " + sb);
        }
    }

    /* ************************************************************************
        G e t t e r  und  S e t t e r
     **************************************************************************/


}
