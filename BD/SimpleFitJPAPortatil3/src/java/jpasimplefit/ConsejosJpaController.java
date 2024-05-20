/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import simplefitjpa.exceptions.NonexistentEntityException;
import simplefitjpa.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class ConsejosJpaController implements Serializable {

    public ConsejosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consejos consejos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consejos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsejos(consejos.getConsejoid()) != null) {
                throw new PreexistingEntityException("Consejos " + consejos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consejos consejos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consejos = em.merge(consejos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consejos.getConsejoid();
                if (findConsejos(id) == null) {
                    throw new NonexistentEntityException("The consejos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consejos consejos;
            try {
                consejos = em.getReference(Consejos.class, id);
                consejos.getConsejoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consejos with id " + id + " no longer exists.", enfe);
            }
            em.remove(consejos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consejos> findConsejosEntities() {
        return findConsejosEntities(true, -1, -1);
    }

    public List<Consejos> findConsejosEntities(int maxResults, int firstResult) {
        return findConsejosEntities(false, maxResults, firstResult);
    }

    private List<Consejos> findConsejosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consejos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Consejos findConsejos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consejos.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsejosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consejos> rt = cq.from(Consejos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
