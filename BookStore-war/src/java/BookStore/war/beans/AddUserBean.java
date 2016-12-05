/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.war.beans;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.UserAcc;
import java.lang.*;

/**
 *
 * @author alex
 */
@Named(value = "AddUserBean")
@RequestScoped
public class AddUserBean {
    private String firstName;
    private String lastName;
    private String email;
    private String loginID;
    private String password;
    private String number;
    private String userType;
    @PersistenceContext(unitName = "BookStore-warPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    private String status;
 

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the status message
     */
    public String getStatus() {
        return status;
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public void addUser() {
        try {
            UserAcc acc = new UserAcc();           
            acc.setFirstName(firstName);
            acc.setLastName(lastName);
            acc.setEmail(email);
            acc.setLoginID(loginID);          
            acc.setNumber(number);
            acc.setUserType(userType);
            // randomly generate salt value
            final Random r = new SecureRandom();
            byte[] salt = new byte[32];
            r.nextBytes(salt);
            String saltString = new String(salt, "UTF-8");
            // hash password using SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String saltedPass = saltString+password;
            byte[] passhash = digest.digest(saltedPass.getBytes("UTF-8"));
            acc.setSalt(salt);
            acc.setPassword(passhash);
            persist(acc);
            status="New Account Created Fine";
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | RuntimeException ex ) {
            System.out.println(ex); 
            Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
            StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
ex.printStackTrace(pw);
sw.toString(); // stack trace as a string
            status="Error While Creating New Account" + ex + sw.toString();
        }
    }
    
}
