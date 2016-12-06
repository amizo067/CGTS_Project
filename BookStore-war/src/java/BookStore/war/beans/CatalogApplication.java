/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.war.beans;

/**
 *
 * @author alex
 */
public final class CatalogApplication {
    private String appId;
    private String presentationType;
    private String presentationTitle;
    private double registrationExpense;
    private double transportationExpense;
    private double accomodationExpense;
    private double mealsExpense;
    
    public CatalogApplication(String appId, String presentationType, String presentationTitle, double registrationExpense, double transportationExpense, double accomodationExpense, double mealsExpense) {
        setAppId(appId);
        setPresentationType(presentationType);
        setPresentationTitle(presentationTitle);
        setRegistrationExpense(registrationExpense);
        setTransportationExpense(transportationExpense);
        setAccomodationExpense(accomodationExpense);
        setMealsExpense(mealsExpense);
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


  

 
}
