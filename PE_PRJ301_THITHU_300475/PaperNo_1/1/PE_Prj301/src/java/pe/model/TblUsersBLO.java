/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class TblUsersBLO implements TblUsersBLI{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PE_Prj301PU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public TblUsers checkLogin(String userID, String password) {
        EntityManager em = emf.createEntityManager();
        TblUsers result = null;
        String jpql = "Select r "
                + "From TblUsers r "
                + "Where r.userID = :userID "
                + "And r.password = :password";
        try{
            Query query = em.createQuery(jpql);
            query.setParameter("userID", userID);
            query.setParameter("password", password);
            result = (TblUsers) query.getSingleResult();
        }finally{
            em.close();
        }
        return result;
    }
    
}
