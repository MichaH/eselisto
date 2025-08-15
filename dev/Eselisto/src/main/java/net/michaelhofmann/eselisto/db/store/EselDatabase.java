/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.db.store;

import java.util.Optional;
import net.michaelhofmann.eselisto.db.entity.User;
import org.apache.commons.configuration2.Configuration;

/**
 *
 * @author michael
 */
public interface EselDatabase {
    
    void start(Configuration config);
    void close();
    
    String getVersion();
    
    User createUser(String userName, String surKey);
    Optional<User> getUserById(String userId);
    Optional<User> getUserByName(String userName);
    
}
