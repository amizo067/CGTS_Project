/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.ejb.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author alex
 */
@Entity
public class Application implements Serializable {
     private static final long serialVersionUID = 1L;
        @Id
    private String appId;
    private String presentationType;
    private String presentationTitle;
    private double registrationExpense;
    private double transportationExpense;
    private double accomodationExpense;
    private double mealsExpense;
    
    public Application() {

    }
    
    public Application(String appId, String presentationType, String presentationTitle, double registrationExpense, double transportationExpense, double accomodationExpense, double mealsExpense) {
        this.appId=appId;
        this.presentationType=presentationType;
        this.presentationTitle=presentationTitle;
        this.registrationExpense=registrationExpense;
        this.transportationExpense=transportationExpense;
        this.accomodationExpense=accomodationExpense;
        this.mealsExpense=mealsExpense;
    }
    
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public double getRegistrationExpense() {
        return registrationExpense;
    }

    public void setRegistrationExpense(double registrationExpense) {
        this.registrationExpense = registrationExpense;
    }

    public double getTransportationExpense() {
        return transportationExpense;
    }

    public void setTransportationExpense(double transportationExpense) {
        this.transportationExpense = transportationExpense;
    }

    public double getAccomodationExpense() {
        return accomodationExpense;
    }

    public void setAccomodationExpense(double accomodationExpense) {
        this.accomodationExpense = accomodationExpense;
    }

    public double getMealsExpense() {
        return mealsExpense;
    }

    public void setMealsExpense(double mealsExpense) {
        this.mealsExpense = mealsExpense;
    }
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.appId != null ? this.appId.hashCode() : 0);
        return hash;
    }

     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application)object;
        if (this.appId != other.appId && (this.appId == null || !this.appId.equals(other.appId))) return false;
        return true;
    }

     @Override
    public String toString() {
        return "Library.persistence.Application[id=" + appId + "]";
    }
}
