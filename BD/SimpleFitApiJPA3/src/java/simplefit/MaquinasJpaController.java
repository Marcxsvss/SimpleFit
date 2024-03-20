/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import simplefit.exceptions.NonexistentEntityException;
import simplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class MaquinasJpaController implements Serializable {

    public MaquinasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maquinas maquinas) throws PreexistingEntityException, Exception {
        if (maquinas.getRutinasCollection() == null) {
            maquinas.setRutinasCollection(new ArrayList<Rutinas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rutinas> attachedRutinasCollection = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionRutinasToAttach : maquinas.getRutinasCollection()) {
                rutinasCollectionRutinasToAttach = em.getReference(rutinasCollectionRutinasToAttach.getClass(), rutinasCollectionRutinasToAttach.getRutinaid());
                attachedRutinasCollection.add(rutinasCollectionRutinasToAttach);
            }
            maquinas.setRutinasCollection(attachedRutinasCollection);
            em.persist(maquinas);
            for (Rutinas rutinasCollectionRutinas : maquinas.getRutinasCollection()) {
                rutinasCollectionRutinas.getMaquinasCollection().add(maquinas);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaquinas(maquinas.getMaquinaid()) != null) {
                throw new PreexistingEntityException("Maquinas " + maquinas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maquinas maquinas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas persistentMaquinas = em.find(Maquinas.class, maquinas.getMaquinaid());
            Collection<Rutinas> rutinasCollectionOld = persistentMaquinas.getRutinasCollection();
            Collection<Rutinas> rutinasCollectionNew = maquinas.getRutinasCollection();
            Collection<Rutinas> attachedRutinasCollectionNew = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionNewRutinasToAttach : rutinasCollectionNew) {
                rutinasCollectionNewRutinasToAttach = em.getReference(rutinasCollectionNewRutinasToAttach.getClass(), rutinasCollectionNewRutinasToAttach.getRutinaid());
                attachedRutinasCollectionNew.add(rutinasCollectionNewRutinasToAttach);
            }
            rutinasCollectionNew = attachedRutinasCollectionNew;
            maquinas.setRutinasCollection(rutinasCollectionNew);
            maquinas = em.merge(maquinas);
            for (Rutinas rutinasCollectionOldRutinas : rutinasCollectionOld) {
                if (!rutinasCollectionNew.contains(rutinasCollectionOldRutinas)) {
                    rutinasCollectionOldRutinas.getMaquinasCollection().remove(maquinas);
                    rutinasCollectionOldRutinas = em.merge(rutinasCollectionOldRutinas);
                }
            }
            for (Rutinas rutinasCollectionNewRutinas : rutinasCollectionNew) {
                if (!rutinasCollectionOld.contains(rutinasCollectionNewRutinas)) {
                    rutinasCollectionNewRutinas.getMaquinasCollection().add(maquinas);
                    rutinasCollectionNewRutinas = em.merge(rutinasCollectionNewRutinas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = maquinas.getMaquinaid();
                if (findMaquinas(id) == null) {
                    throw new NonexistentEntityException("The maquinas with id " + id + " no longer exists.");
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
            Maquinas maquinas;
            try {
                maquinas = em.getReference(Maquinas.class, id);
                maquinas.getMaquinaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maquinas with id " + id + " no longer exists.", enfe);
            }
            Collection<Rutinas> rutinasCollection = maquinas.getRutinasCollection();
            for (Rutinas rutinasCollectionRutinas : rutinasCollection) {
                rutinasCollectionRutinas.getMaquinasCollection().remove(maquinas);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
            }
            em.remove(maquinas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maquinas> findMaquinasEntities() {
        return findMaquinasEntities(true, -1, -1);
    }

    public List<Maquinas> findMaquinasEntities(int maxResults, int firstResult) {
        return findMaquinasEntities(false, maxResults, firstResult);
    }

    private List<Maquinas> findMaquinasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maquinas.class));
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

    public Maquinas findMaquinas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maquinas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaquinasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maquinas> rt = cq.from(Maquinas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
