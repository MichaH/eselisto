/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.eselisto.db.entity;

import java.sql.Timestamp;

/**
 * @author Michael.Hofmann@OrangeObjects.de
 *
 */
public class User {

    private String userId;
    private String userName;
    private Timestamp creationTime;
    private Timestamp lastChange;
    private String surrogateKey;    

    /* ************************************************************************
        C o n s t r u c t o r
     **************************************************************************/

    public User() {
    }

    public User(String userId, String userName, Timestamp creationTime, Timestamp lastChange, String surrogateKey) {
        this.userId = userId;
        this.userName = userName;
        this.creationTime = creationTime;
        this.lastChange = lastChange;
        this.surrogateKey = surrogateKey;
    }
    
    /* ************************************************************************
        M i s c
     **************************************************************************/
    


    /* ************************************************************************
        G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastChange() {
        return lastChange;
    }

    public void setLastChange(Timestamp lastChange) {
        this.lastChange = lastChange;
    }

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }
}
