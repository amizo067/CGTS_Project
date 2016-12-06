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
@Named(value = "applicationBean")
@RequestScoped
public class ApplicationBean {
    @EJB
    private ApplicationFacadeLocal applicationFacade;
    private String id;
    private String presentationType;
    private String presentationTitle;
    private double registrationExpense;
    private double transportationExpense;
    private double accomodationExpense;
    private double mealsExpense;
    private String status; 
    
    public ApplicationBean(){
    
    }
    
    public String getID(){
        return id;
    }
    
    public void setID(String id){
       this.id=id;
    }
    public ApplicationFacadeLocal getItemFacade() {
        return applicationFacade;
    }

    public void setItemFacade(ApplicationFacadeLocal applicationFacade) {
        this.applicationFacade = applicationFacade;
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
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        if (applicationFacade.addApplication(id,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense)) {
           status = bundle.getString("addOk");
        } else {
           status = bundle.getString("addFail");
        }
    }
}


