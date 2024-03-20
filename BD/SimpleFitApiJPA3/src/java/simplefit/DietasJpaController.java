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
import simplefit.exceptions.IllegalOrphanException;
import simplefit.exceptions.NonexistentEntityException;
import simplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class DietasJpaController implements Serializable {

    public DietasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dietas dietas) throws PreexistingEntityException, Exception {
        if (dietas.getDietaalimentoCollection() == null) {
            dietas.setDietaalimentoCollection(new ArrayList<Dietaalimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userid = dietas.getUserid();
            if (userid != null) {
                userid = em.getReference(userid.getClass(), userid.getDni());
                dietas.setUserid(userid);
            }
            Collection<Dietaalimento> attachedDietaalimentoCollection = new ArrayList<Dietaalimento>();
            for (Dietaalimento dietaalimentoCollectionDietaalimentoToAttach : dietas.getDietaalimentoCollection()) {
                dietaalimentoCollectionDietaalimentoToAttach = em.getReference(dietaalimentoCollectionDietaalimentoToAttach.getClass(), dietaalimentoCollectionDietaalimentoToAttach.getDietaalimentoPK());
                attachedDietaalimentoCollection.add(dietaalimentoCollectionDietaalimentoToAttach);
            }
            dietas.setDietaalimentoCollection(attachedDietaalimentoCollection);
            em.persist(dietas);
            if (userid != null) {
                userid.getDietasCollection().add(dietas);
                userid = em.merge(userid);
            }
            for (Dietaalimento dietaalimentoCollectionDietaalimento : dietas.getDietaalimentoCollection()) {
                Dietas oldDietasOfDietaalimentoCollectionDietaalimento = dietaalimentoCollectionDietaalimento.getDietas();
                dietaalimentoCollectionDietaalimento.setDietas(dietas);
                dietaalimentoCollectionDietaalimento = em.merge(dietaalimentoCollectionDietaalimento);
                if (oldDietasOfDietaalimentoCollectionDietaalimento != null) {
                    oldDietasOfDietaalimentoCollectionDietaalimento.getDietaalimentoCollection().remove(dietaalimentoCollectionDietaalimento);
                    oldDietasOfDietaalimentoCollectionDietaalimento = em.merge(oldDietasOfDietaalimentoCollectionDietaalimento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDietas(dietas.getDietaid()) != null) {
                throw new PreexistingEntityException("Dietas " + dietas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dietas dietas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dietas persistentDietas = em.find(Dietas.class, dietas.getDietaid());
            Users useridOld = persistentDietas.getUserid();
            Users useridNew = dietas.getUserid();
            Collection<Dietaalimento> dietaalimentoCollectionOld = persistentDietas.getDietaalimentoCollection();
            Collection<Dietaalimento> dietaalimentoCollectionNew = dietas.getDietaalimentoCollection();
            List<String> illegalOrphanMessages = null;
            for (Dietaalimento dietaalimentoCollectionOldDietaalimento : dietaalimentoCollectionOld) {
                if (!dietaalimentoCollectionNew.contains(dietaalimentoCollectionOldDietaalimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dietaalimento " + dietaalimentoCollectionOldDietaalimento + " since its dietas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (useridNew != null) {
                useridNew = em.getReference(useridNew.getClass(), useridNew.getDni());
                dietas.setUserid(useridNew);
            }
            Collection<Dietaalimento> attachedDietaalimentoCollectionNew = new ArrayList<Dietaalimento>();
            for (Dietaalimento dietaalimentoCollectionNewDietaalimentoToAttach : dietaalimentoCollectionNew) {
                dietaalimentoCollectionNewDietaalimentoToAttach = em.getReference(dietaalimentoCollectionNewDietaalimentoToAttach.getClass(), dietaalimentoCollectionNewDietaalimentoToAttach.getDietaalimentoPK());
                attachedDietaalimentoCollectionNew.add(dietaalimentoCollectionNewDietaalimentoToAttach);
            }
            dietaalimentoCollectionNew = attachedDietaalimentoCollectionNew;
            dietas.setDietaalimentoCollection(dietaalimentoCollectionNew);
            dietas = em.merge(dietas);
            if (useridOld != null && !useridOld.equals(useridNew)) {
                useridOld.getDietasCollection().remove(dietas);
                useridOld = em.merge(useridOld);
            }
            if (useridNew != null && !useridNew.equals(useridOld)) {
                useridNew.getDietasCollection().add(dietas);
                useridNew = em.merge(useridNew);
            }
            for (Dietaalimento dietaalimentoCollectionNewDietaalimento : dietaalimentoCollectionNew) {
                if (!dietaalimentoCollectionOld.contains(dietaalimentoCollectionNewDietaalimento)) {
                    Dietas oldDietasOfDietaalimentoCollectionNewDietaalimento = dietaalimentoCollectionNewDietaalimento.getDietas();
                    dietaalimentoCollectionNewDietaalimento.setDietas(dietas);
                    dietaalimentoCollectionNewDietaalimento = em.merge(dietaalimentoCollectionNewDietaalimento);
                    if (oldDietasOfDietaalimentoCollectionNewDietaalimento != null && !oldDietasOfDietaalimentoCollectionNewDietaalimento.equals(dietas)) {
                        oldDietasOfDietaalimentoCollectionNewDietaalimento.getDietaalimentoCollection().remove(dietaalimentoCollectionNewDietaalimento);
                        oldDietasOfDietaalimentoCollectionNewDietaalimento = em.merge(oldDietasOfDietaalimentoCollectionNewDietaalimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dietas.getDietaid();
                if (findDietas(id) == null) {
                    throw new NonexistentEntityException("The dietas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dietas dietas;
            try {
                dietas = em.getReference(Dietas.class, id);
                dietas.getDietaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dietas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Dietaalimento> dietaalimentoCollectionOrphanCheck = dietas.getDietaalimentoCollection();
            for (Dietaalimento dietaalimentoCollectionOrphanCheckDietaalimento : dietaalimentoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dietas (" + dietas + ") cannot be destroyed since the Dietaalimento " + dietaalimentoCollectionOrphanCheckDietaalimento + " in its dietaalimentoCollection field has a non-nullable dietas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Users userid = dietas.getUserid();
            if (userid != null) {
                userid.getDietasCollection().remove(dietas);
                userid = em.merge(userid);
            }
            em.remove(dietas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dietas> findDietasEntities() {
        return findDietasEntities(true, -1, -1);
    }

    public List<Dietas> findDietasEntities(int maxResults, int firstResult) {
        return findDietasEntities(false, maxResults, firstResult);
    }

    private List<Dietas> findDietasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dietas.class));
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

    public Dietas findDietas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dietas.class, id);
        } finally {
            em.close();
        }
    }

    public int getDietasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dietas> rt = cq.from(Dietas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
