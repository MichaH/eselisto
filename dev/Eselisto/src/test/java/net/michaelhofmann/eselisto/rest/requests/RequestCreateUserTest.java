/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.rest.requests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michael
 */
public class RequestCreateUserTest {
    
    private MultiValidator validator;
    
    public RequestCreateUserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        validator = new MultiValidator();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /*  ***********************************************************************
     *  T e s t
     **************************************************************************/
    @Test
    void testValidUser_shouldPassValidation() {

        RequestCreateUser req = new RequestCreateUser("michael", "SURR-001");
        assertDoesNotThrow(() -> validator.validate(req),
                "Ein gültiges Objekt sollte keine Exception auslösen");
    }

    /*  ***********************************************************************
     *  T e s t
     **************************************************************************/
    @Test
    void testNullUserName_shouldFailValidation() {
        
        RequestCreateUser req = new RequestCreateUser(null, "SURR-002");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(req));
        System.out.println(ex.getMessage());
    }

    /*  ***********************************************************************
     *  T e s t
     **************************************************************************/
    @Test
    void testBlankUserName_shouldFailValidation() {
        
        RequestCreateUser req = new RequestCreateUser("   ", "SURR-003");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(req));
        System.out.println(ex.getMessage());
    }
}
