/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStore.ejb.beans;

import BookStore.ejb.persistence.Application;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alex
 */
@Stateless
public class ApplicationFacade extends AbstractFacade<Application> implements ApplicationFacadeLocal {
    @PersistenceContext(unitName = "BookStore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicationFacade() {
        super(Application.class);
    }

    @Override
    public boolean addApplication(String appId, String presentationType, String presentationTitle, double registrationExpense, double transportationExpense, double accomodationExpense, double mealsExpense,String appStatus){
        Application application = new Application(appId,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense,appStatus);
        try {
            create(application);
        } catch (Exception e) {
            return false ;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Application> findAllApplication() {
        try {
            Query query = em.createQuery(
                "SELECT u FROM Application u");         
            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }    
    
    @Override
    public boolean updateApplication(String appID,String appStatus){
        try {
//            Application application =(Application)em.find(Application.class,appID);
            Query query;
            if (appStatus.equals("Approve") ){
                 query = em.createQuery("update Application  a set a.appStatus= 'Approve' where a.appId= :appID");
            }else if(appStatus.equals("Return")){
                 query = em.createQuery("update Application  a set a.appStatus= 'Return' where a.appId= :appID");
            }else{
                 query = em.createQuery("update Application  a set a.appStatus= 'Reject' where a.appId= :appID");
            }              
                   
            query.setParameter("appID",appID);
            query.executeUpdate();
            
            return true;
        } catch (Exception e) {
        }
        return false;
    }    
    
}