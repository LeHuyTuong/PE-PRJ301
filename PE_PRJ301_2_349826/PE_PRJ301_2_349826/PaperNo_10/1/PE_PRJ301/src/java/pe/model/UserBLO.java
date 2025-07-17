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
public class UserBLO implements UserBLI{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PE_PRJ301PU");

    @Override
    public TblUser checkLogin(String userID, String password) {
        TblUser result = null;
        EntityManager em = emf.createEntityManager();
        String jpql = "Select r "
                + "From TblUser r "
                + "Where r.userID = :userID "
                + "And r.password = :password";
        try{
            Query query = em.createQuery(jpql);
            query.setParameter("userID", userID);
            query.setParameter("password", password);
            result = (TblUser) query.getSingleResult();
        }finally{
            em.close();
        }
        return result;
    }

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
    
}
