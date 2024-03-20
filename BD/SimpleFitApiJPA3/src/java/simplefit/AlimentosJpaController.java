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
public class AlimentosJpaController implements Serializable {

    public AlimentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alimentos alimentos) throws PreexistingEntityException, Exception {
        if (alimentos.getDietaalimentoCollection() == null) {
            alimentos.setDietaalimentoCollection(new ArrayList<Dietaalimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Dietaalimento> attachedDietaalimentoCollection = new ArrayList<Dietaalimento>();
            for (Dietaalimento dietaalimentoCollectionDietaalimentoToAttach : alimentos.getDietaalimentoCollection()) {
                dietaalimentoCollectionDietaalimentoToAttach = em.getReference(dietaalimentoCollectionDietaalimentoToAttach.getClass(), dietaalimentoCollectionDietaalimentoToAttach.getDietaalimentoPK());
                attachedDietaalimentoCollection.add(dietaalimentoCollectionDietaalimentoToAttach);
            }
            alimentos.setDietaalimentoCollection(attachedDietaalimentoCollection);
            em.persist(alimentos);
            for (Dietaalimento dietaalimentoCollectionDietaalimento : alimentos.getDietaalimentoCollection()) {
                Alimentos oldAlimentosOfDietaalimentoCollectionDietaalimento = dietaalimentoCollectionDietaalimento.getAlimentos();
                dietaalimentoCollectionDietaalimento.setAlimentos(alimentos);
                dietaalimentoCollectionDietaalimento = em.merge(dietaalimentoCollectionDietaalimento);
                if (oldAlimentosOfDietaalimentoCollectionDietaalimento != null) {
                    oldAlimentosOfDietaalimentoCollectionDietaalimento.getDietaalimentoCollection().remove(dietaalimentoCollectionDietaalimento);
                    oldAlimentosOfDietaalimentoCollectionDietaalimento = em.merge(oldAlimentosOfDietaalimentoCollectionDietaalimento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlimentos(alimentos.getAlimentoid()) != null) {
                throw new PreexistingEntityException("Alimentos " + alimentos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alimentos alimentos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alimentos persistentAlimentos = em.find(Alimentos.class, alimentos.getAlimentoid());
            Collection<Dietaalimento> dietaalimentoCollectionOld = persistentAlimentos.getDietaalimentoCollection();
            Collection<Dietaalimento> dietaalimentoCollectionNew = alimentos.getDietaalimentoCollection();
            List<String> illegalOrphanMessages = null;
            for (Dietaalimento dietaalimentoCollectionOldDietaalimento : dietaalimentoCollectionOld) {
                if (!dietaalimentoCollectionNew.contains(dietaalimentoCollectionOldDietaalimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dietaalimento " + dietaalimentoCollectionOldDietaalimento + " since its alimentos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Dietaalimento> attachedDietaalimentoCollectionNew = new ArrayList<Dietaalimento>();
            for (Dietaalimento dietaalimentoCollectionNewDietaalimentoToAttach : dietaalimentoCollectionNew) {
                dietaalimentoCollectionNewDietaalimentoToAttach = em.getReference(dietaalimentoCollectionNewDietaalimentoToAttach.getClass(), dietaalimentoCollectionNewDietaalimentoToAttach.getDietaalimentoPK());
                attachedDietaalimentoCollectionNew.add(dietaalimentoCollectionNewDietaalimentoToAttach);
            }
            dietaalimentoCollectionNew = attachedDietaalimentoCollectionNew;
            alimentos.setDietaalimentoCollection(dietaalimentoCollectionNew);
            alimentos = em.merge(alimentos);
            for (Dietaalimento dietaalimentoCollectionNewDietaalimento : dietaalimentoCollectionNew) {
                if (!dietaalimentoCollectionOld.contains(dietaalimentoCollectionNewDietaalimento)) {
                    Alimentos oldAlimentosOfDietaalimentoCollectionNewDietaalimento = dietaalimentoCollectionNewDietaalimento.getAlimentos();
                    dietaalimentoCollectionNewDietaalimento.setAlimentos(alimentos);
                    dietaalimentoCollectionNewDietaalimento = em.merge(dietaalimentoCollectionNewDietaalimento);
                    if (oldAlimentosOfDietaalimentoCollectionNewDietaalimento != null && !oldAlimentosOfDietaalimentoCollectionNewDietaalimento.equals(alimentos)) {
                        oldAlimentosOfDietaalimentoCollectionNewDietaalimento.getDietaalimentoCollection().remove(dietaalimentoCollectionNewDietaalimento);
                        oldAlimentosOfDietaalimentoCollectionNewDietaalimento = em.merge(oldAlimentosOfDietaalimentoCollectionNewDietaalimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alimentos.getAlimentoid();
                if (findAlimentos(id) == null) {
                    throw new NonexistentEntityException("The alimentos with id " + id + " no longer exists.");
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
            Alimentos alimentos;
            try {
                alimentos = em.getReference(Alimentos.class, id);
                alimentos.getAlimentoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alimentos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Dietaalimento> dietaalimentoCollectionOrphanCheck = alimentos.getDietaalimentoCollection();
            for (Dietaalimento dietaalimentoCollectionOrphanCheckDietaalimento : dietaalimentoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alimentos (" + alimentos + ") cannot be destroyed since the Dietaalimento " + dietaalimentoCollectionOrphanCheckDietaalimento + " in its dietaalimentoCollection field has a non-nullable alimentos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alimentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alimentos> findAlimentosEntities() {
        return findAlimentosEntities(true, -1, -1);
    }

    public List<Alimentos> findAlimentosEntities(int maxResults, int firstResult) {
        return findAlimentosEntities(false, maxResults, firstResult);
    }

    private List<Alimentos> findAlimentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alimentos.class));
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

    public Alimentos findAlimentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alimentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlimentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alimentos> rt = cq.from(Alimentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
