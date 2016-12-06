/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.war.beans;


import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.ReqApp;
import java.lang.*;

/**
 *
 * @author alex
 */
@Named(value = "ReqAppBean")
@RequestScoped
public class ReqAppBean {
  
    //private ApplicationFacadeLocal applicationFacade;
    private String appID;
    private String presentationType;
    private String presentationTitle;
    private double registrationExpense;
    private double transportationExpense;
    private double accomodationExpense;
    private double mealsExpense;
    private String status; 
    private String recommendation;
    @PersistenceContext(unitName = "BookStore-warPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public ReqAppBean(){
    
    }
      
    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }    
  
    public String getAppID(){
        return appID;
    }
    
    public void setAppID(String appID){
       this.appID=appID;
    }
//    public ApplicationFacadeLocal getItemFacade() {
//        return applicationFacade;
//    }
//
//    public void setItemFacade(ApplicationFacadeLocal applicationFacade) {
//        this.applicationFacade = applicationFacade;
//    }

    public String getPresentationType() {
        return presentationType;
    }

    public void setPresentationType(String presentationType) {
        this.presentationType = presentationType;
    }

    public String getPresentationTitle() {
        return presentationTitle;
    }

    public void setPresentationTitle(String presentationTitle) {
        this.presentationTitle = presentationTitle;
    }

    public Double getRegistrationExpense() {
        return registrationExpense;
    }

    public void setRegistrationExpense(Double registrationExpense) {
        this.registrationExpense = registrationExpense;
    }

    public Double getTransportationExpense() {
        return transportationExpense;
    }
    
    public String getStatus(){
        return status;
    }
    public void setTransportationExpense(Double transportationExpense) {
        this.transportationExpense = transportationExpense;
    }

    public Double getAccomodationExpense() {
        return accomodationExpense;
    }

    public void setAccomodationExpense(Double accomodationExpense) {
        this.accomodationExpense = accomodationExpense;
    }

    public Double getMealsExpense() {
        return mealsExpense;
    }
  public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    public void setMealsExpense(Double mealsExpense) {
        this.mealsExpense = mealsExpense;
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

    public void addApplication() {
        try {
            ReqApp app = new ReqApp();     
            app.setAppId(appID);
            app.setPresentationType(presentationType);
            app.setPresentationTitle(presentationTitle);
            app.setRegistrationExpense(registrationExpense);
            app.setTransportationExpense(transportationExpense);          
            app.setAccomodationExpense(accomodationExpense);
            app.setMealsExpense(mealsExpense);           
            persist(app);
            status="New Account Created Fine";
        } catch (RuntimeException ex ) {
            System.out.println(ex); 
            Logger.getLogger(ReqAppBean.class.getName()).log(Level.SEVERE, null, ex);
            StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
ex.printStackTrace(pw);
sw.toString(); // stack trace as a string
            status="Error While Creating New Account" + ex + sw.toString();
        }
    }
//    public void addApplication() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
//        if (applicationFacade.addApplication(id,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense)) {
//           status = bundle.getString("addOk");
//        } else {
//           status = bundle.getString("addFail");
//        }
//    }
//     public void makeRecommendation() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
//        if (applicationFacade.addApplication(id,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense)) {
//           status = bundle.getString("addOk");
//        } else {
//           status = bundle.getString("addFail");
//        }
//    }
}


