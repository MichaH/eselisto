/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.db.store.memory;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import net.michaelhofmann.eselisto.db.entity.User;
import net.michaelhofmann.eselisto.db.store.EselDatabase;
import org.apache.commons.configuration2.Configuration;

/**
 *
 * @author michael
 */
public class UserRepo implements EselDatabase {
    
    private static final Map<String, User> users = new HashMap<>();

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    private UserRepo() {
    }
    
    public static UserRepo getInstance() {
        return UserRepoHolder.INSTANCE;
    }

    private static class UserRepoHolder {

        private static final UserRepo INSTANCE = new UserRepo();

        private UserRepoHolder() {
        }
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void start(Configuration config) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getVersion() {
        return "datamodel 1.0";
    }

    @Override
    public User createUser(String userName, String surKey) {
        String userId = UUID.randomUUID().toString();
        Timestamp now = new Timestamp(System.currentTimeMillis());

        User user = new User(userId, userName, now, now, surKey);
        users.put(userId, user);
        return user;
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public Optional<User> getUserByName(final String userName) {
        return users.values().stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst();
    }
}
