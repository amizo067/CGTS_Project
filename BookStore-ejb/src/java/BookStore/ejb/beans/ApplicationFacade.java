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
    public boolean addApplication(String id, String presentationType, String presentationTitle, double registrationExpense, double transportationExpense, double accomodationExpense, double mealsExpense){
        Application application = new Application(id,presentationType, presentationTitle,registrationExpense,transportationExpense, accomodationExpense, mealsExpense);
        try {
            create(application);
        } catch (Exception e) {
            return false ;
        }
        return true;
    }

    @Override
    public List<Application> findAllApplication() {
        try {
            Query query = em.createQuery(
                "SELECT * FROM Application");         
            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }    
}
