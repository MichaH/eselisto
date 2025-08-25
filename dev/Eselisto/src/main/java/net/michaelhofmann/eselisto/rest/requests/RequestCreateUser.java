/*
 *  O R A N G E   O B J E C T S
 * 
 *  copyright by Orange Objects
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.eselisto.rest.requests;

import java.util.Objects;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author michael
 */
public class RequestCreateUser{
    
    @NotBlank(message = "userName is required")
    private String userName;
    private String surrogateKey;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public RequestCreateUser() {
    }

    public RequestCreateUser(String userName, String surrogateKey) {
        this.userName = userName;
        this.surrogateKey = surrogateKey;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RequestCreateUser other = (RequestCreateUser) obj;
        return Objects.equals(this.userName, other.userName);
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }
}
