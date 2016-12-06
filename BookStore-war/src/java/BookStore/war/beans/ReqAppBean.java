/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.war.beans;


import BookStore.ejb.beans.ApplicationFacadeLocal;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author alex
 */
@Named(value = "ReqAppBean")
@RequestScoped
public class ReqAppBean {
    @EJB
    private ApplicationFacadeLocal applicationFacade;
    private String appID;
    private String presentationType;
    private String presentationTitle;
    private double registrationExpense;
    private double transportationExpense;
    private double accomodationExpense;
    private double mealsExpense;
    private String status; 
    private String recommendation;
    private String appStatus;

    
    
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
    public ApplicationFacadeLocal getApplicationFacade() {
        return applicationFacade;
    }

    public void setApplicationFacade(ApplicationFacadeLocal applicationFacade) {
        this.applicationFacade = applicationFacade;
    }
    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
    
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
  
    public void setMealsExpense(Double mealsExpense) {
        this.mealsExpense = mealsExpense;
    }


    public void addApplication() {
        if (applicationFacade.addApplication(appID,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense,appStatus)) {
           status = "Successful-Application was created";
        } else {
           status = "Failed-Application wasn't created";
        }
    }
     public void makeRecommendation() {
        
        if (applicationFacade.addApplication(appID,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense,appStatus)) {
           status = "Successful-Recommendation has been submitted";
        } else {
           status = "Failed-Recommendation was not submitted";
        }
    }

   
}


