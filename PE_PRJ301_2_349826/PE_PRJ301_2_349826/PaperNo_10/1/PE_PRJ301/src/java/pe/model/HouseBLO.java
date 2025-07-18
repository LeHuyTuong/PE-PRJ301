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

/**
 *
 * @author USER
 */
public class HouseBLO implements HouseBLI {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PE_PRJ301PU");

    @Override
    public boolean createHouse(TblHouse house) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try {
            TblHouse hou = em.find(TblHouse.class, house.getId());
            if (hou == null) {
                em.getTransaction().begin();
                em.persist(hou);
                em.getTransaction().commit();
                result = true;
            }
        } finally {
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
