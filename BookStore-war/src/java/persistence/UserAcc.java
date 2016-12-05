/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author alex
 */
@Entity
public class UserAcc implements Serializable {

    private static final long serialVersionUID = 1L;
        @Id
    private String firstName;
    private String lastName;
    private String email;
    private String loginID;
    private String number;
    private String userType;

   
    @Lob
    private byte[] password; // salted + hashed password
    @Lob
    private byte[] salt; // the salt used for this account
    
      
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setLoginID(String loginID) {
        this.loginID=loginID;
    }

    
    public void setNumber(String number) {
        this.number=number;
    }
    
    public void setUserType(String userType) {
        this.userType=userType;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getUserType() {
        return userType;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLoginID() {
        return loginID;
    }

     /**
     * @return the password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }
    
        /**
     * @return the salt
     */
    public byte[] getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
      @Override
    public int hashCode() {
        int hash = 0;
        hash += (getLoginID() != null ? getLoginID().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAcc)) {
            return false;
        }
        UserAcc other = (UserAcc) object;
        if ((this.getLoginID() == null && other.getLoginID() != null) || (this.getLoginID() != null && !this.loginID.equals(other.loginID))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return "Library.persistence.User[id=" + loginID + "]";
    }
}
