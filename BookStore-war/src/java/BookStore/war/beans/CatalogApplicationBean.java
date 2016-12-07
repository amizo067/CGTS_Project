/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.war.beans;

import BookStore.ejb.beans.ApplicationFacadeLocal;
import BookStore.ejb.persistence.Application;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@Named(value = "catalogApplicationBean")
@SessionScoped
public class CatalogApplicationBean implements Serializable {
    @EJB
    private ApplicationFacadeLocal applicationFacade;
     
    
   
    private ArrayList<CatalogApplication> applications;
    
    
  


    /**
     * @return the applications
     */
    public ArrayList<CatalogApplication> getApplication() {
        return applications;
    }

    /**
     * @param applications the applications to set
     */
    public void setApplication(ArrayList<CatalogApplication> applications) {
        this.applications = applications;
    }
  

    
    /**
     * Creates a new instance of CatalogBean
     */
    public CatalogApplicationBean() {
    }
    
    public String getAllApplications() {
        
        applications=new ArrayList<>();
        List<Application> resultList = applicationFacade.findAllApplication();
        if (resultList != null) {
            for (Application resultList1 : resultList) {
                Application x = (Application) resultList1;
                applications.add(new CatalogApplication(x.getAppId(),x.getPresentationType(),x.getPresentationTitle(),x.getRegistrationExpense(),x.getTransportationExpense(),x.getAccomodationExpense(),x.getMealsExpense(),x.getAppStatus()));
            }
        }
        return "makeRecommendation";
    }
  
  
}
