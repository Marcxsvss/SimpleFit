/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import simplefit.exceptions.NonexistentEntityException;
import simplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class RutinasJpaController implements Serializable {

    public RutinasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rutinas rutinas) throws PreexistingEntityException, Exception {
        if (rutinas.getMaquinasCollection() == null) {
            rutinas.setMaquinasCollection(new ArrayList<Maquinas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userid = rutinas.getUserid();
            if (userid != null) {
                userid = em.getReference(userid.getClass(), userid.getDni());
                rutinas.setUserid(userid);
            }
            Collection<Maquinas> attachedMaquinasCollection = new ArrayList<Maquinas>();
            for (Maquinas maquinasCollectionMaquinasToAttach : rutinas.getMaquinasCollection()) {
                maquinasCollectionMaquinasToAttach = em.getReference(maquinasCollectionMaquinasToAttach.getClass(), maquinasCollectionMaquinasToAttach.getMaquinaid());
                attachedMaquinasCollection.add(maquinasCollectionMaquinasToAttach);
            }
            rutinas.setMaquinasCollection(attachedMaquinasCollection);
            em.persist(rutinas);
            if (userid != null) {
                userid.getRutinasCollection().add(rutinas);
                userid = em.merge(userid);
            }
            for (Maquinas maquinasCollectionMaquinas : rutinas.getMaquinasCollection()) {
                maquinasCollectionMaquinas.getRutinasCollection().add(rutinas);
                maquinasCollectionMaquinas = em.merge(maquinasCollectionMaquinas);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutinas(rutinas.getRutinaid()) != null) {
                throw new PreexistingEntityException("Rutinas " + rutinas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rutinas rutinas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutinas persistentRutinas = em.find(Rutinas.class, rutinas.getRutinaid());
            Users useridOld = persistentRutinas.getUserid();
            Users useridNew = rutinas.getUserid();
            Collection<Maquinas> maquinasCollectionOld = persistentRutinas.getMaquinasCollection();
            Collection<Maquinas> maquinasCollectionNew = rutinas.getMaquinasCollection();
            if (useridNew != null) {
                useridNew = em.getReference(useridNew.getClass(), useridNew.getDni());
                rutinas.setUserid(useridNew);
            }
            Collection<Maquinas> attachedMaquinasCollectionNew = new ArrayList<Maquinas>();
            for (Maquinas maquinasCollectionNewMaquinasToAttach : maquinasCollectionNew) {
                maquinasCollectionNewMaquinasToAttach = em.getReference(maquinasCollectionNewMaquinasToAttach.getClass(), maquinasCollectionNewMaquinasToAttach.getMaquinaid());
                attachedMaquinasCollectionNew.add(maquinasCollectionNewMaquinasToAttach);
            }
            maquinasCollectionNew = attachedMaquinasCollectionNew;
            rutinas.setMaquinasCollection(maquinasCollectionNew);
            rutinas = em.merge(rutinas);
            if (useridOld != null && !useridOld.equals(useridNew)) {
                useridOld.getRutinasCollection().remove(rutinas);
                useridOld = em.merge(useridOld);
            }
            if (useridNew != null && !useridNew.equals(useridOld)) {
                useridNew.getRutinasCollection().add(rutinas);
                useridNew = em.merge(useridNew);
            }
            for (Maquinas maquinasCollectionOldMaquinas : maquinasCollectionOld) {
                if (!maquinasCollectionNew.contains(maquinasCollectionOldMaquinas)) {
                    maquinasCollectionOldMaquinas.getRutinasCollection().remove(rutinas);
                    maquinasCollectionOldMaquinas = em.merge(maquinasCollectionOldMaquinas);
                }
            }
            for (Maquinas maquinasCollectionNewMaquinas : maquinasCollectionNew) {
                if (!maquinasCollectionOld.contains(maquinasCollectionNewMaquinas)) {
                    maquinasCollectionNewMaquinas.getRutinasCollection().add(rutinas);
                    maquinasCollectionNewMaquinas = em.merge(maquinasCollectionNewMaquinas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rutinas.getRutinaid();
                if (findRutinas(id) == null) {
                    throw new NonexistentEntityException("The rutinas with id " + id + " no longer exists.");
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
            Rutinas rutinas;
            try {
                rutinas = em.getReference(Rutinas.class, id);
                rutinas.getRutinaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutinas with id " + id + " no longer exists.", enfe);
            }
            Users userid = rutinas.getUserid();
            if (userid != null) {
                userid.getRutinasCollection().remove(rutinas);
                userid = em.merge(userid);
            }
            Collection<Maquinas> maquinasCollection = rutinas.getMaquinasCollection();
            for (Maquinas maquinasCollectionMaquinas : maquinasCollection) {
                maquinasCollectionMaquinas.getRutinasCollection().remove(rutinas);
                maquinasCollectionMaquinas = em.merge(maquinasCollectionMaquinas);
            }
            em.remove(rutinas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rutinas> findRutinasEntities() {
        return findRutinasEntities(true, -1, -1);
    }

    public List<Rutinas> findRutinasEntities(int maxResults, int firstResult) {
        return findRutinasEntities(false, maxResults, firstResult);
    }

    private List<Rutinas> findRutinasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rutinas.class));
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

    public Rutinas findRutinas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rutinas.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutinasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rutinas> rt = cq.from(Rutinas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
