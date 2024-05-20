/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

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
import simplefitjpa.exceptions.IllegalOrphanException;
import simplefitjpa.exceptions.NonexistentEntityException;
import simplefitjpa.exceptions.PreexistingEntityException;

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
        if (maquinas.getRutinamaquinaCollection() == null) {
            maquinas.setRutinamaquinaCollection(new ArrayList<Rutinamaquina>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rutinamaquina> attachedRutinamaquinaCollection = new ArrayList<Rutinamaquina>();
            for (Rutinamaquina rutinamaquinaCollectionRutinamaquinaToAttach : maquinas.getRutinamaquinaCollection()) {
                rutinamaquinaCollectionRutinamaquinaToAttach = em.getReference(rutinamaquinaCollectionRutinamaquinaToAttach.getClass(), rutinamaquinaCollectionRutinamaquinaToAttach.getRutinamaquinaPK());
                attachedRutinamaquinaCollection.add(rutinamaquinaCollectionRutinamaquinaToAttach);
            }
            maquinas.setRutinamaquinaCollection(attachedRutinamaquinaCollection);
            em.persist(maquinas);
            for (Rutinamaquina rutinamaquinaCollectionRutinamaquina : maquinas.getRutinamaquinaCollection()) {
                Maquinas oldMaquinasOfRutinamaquinaCollectionRutinamaquina = rutinamaquinaCollectionRutinamaquina.getMaquinas();
                rutinamaquinaCollectionRutinamaquina.setMaquinas(maquinas);
                rutinamaquinaCollectionRutinamaquina = em.merge(rutinamaquinaCollectionRutinamaquina);
                if (oldMaquinasOfRutinamaquinaCollectionRutinamaquina != null) {
                    oldMaquinasOfRutinamaquinaCollectionRutinamaquina.getRutinamaquinaCollection().remove(rutinamaquinaCollectionRutinamaquina);
                    oldMaquinasOfRutinamaquinaCollectionRutinamaquina = em.merge(oldMaquinasOfRutinamaquinaCollectionRutinamaquina);
                }
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

    public void edit(Maquinas maquinas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas persistentMaquinas = em.find(Maquinas.class, maquinas.getMaquinaid());
            Collection<Rutinamaquina> rutinamaquinaCollectionOld = persistentMaquinas.getRutinamaquinaCollection();
            Collection<Rutinamaquina> rutinamaquinaCollectionNew = maquinas.getRutinamaquinaCollection();
            List<String> illegalOrphanMessages = null;
            for (Rutinamaquina rutinamaquinaCollectionOldRutinamaquina : rutinamaquinaCollectionOld) {
                if (!rutinamaquinaCollectionNew.contains(rutinamaquinaCollectionOldRutinamaquina)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rutinamaquina " + rutinamaquinaCollectionOldRutinamaquina + " since its maquinas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Rutinamaquina> attachedRutinamaquinaCollectionNew = new ArrayList<Rutinamaquina>();
            for (Rutinamaquina rutinamaquinaCollectionNewRutinamaquinaToAttach : rutinamaquinaCollectionNew) {
                rutinamaquinaCollectionNewRutinamaquinaToAttach = em.getReference(rutinamaquinaCollectionNewRutinamaquinaToAttach.getClass(), rutinamaquinaCollectionNewRutinamaquinaToAttach.getRutinamaquinaPK());
                attachedRutinamaquinaCollectionNew.add(rutinamaquinaCollectionNewRutinamaquinaToAttach);
            }
            rutinamaquinaCollectionNew = attachedRutinamaquinaCollectionNew;
            maquinas.setRutinamaquinaCollection(rutinamaquinaCollectionNew);
            maquinas = em.merge(maquinas);
            for (Rutinamaquina rutinamaquinaCollectionNewRutinamaquina : rutinamaquinaCollectionNew) {
                if (!rutinamaquinaCollectionOld.contains(rutinamaquinaCollectionNewRutinamaquina)) {
                    Maquinas oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina = rutinamaquinaCollectionNewRutinamaquina.getMaquinas();
                    rutinamaquinaCollectionNewRutinamaquina.setMaquinas(maquinas);
                    rutinamaquinaCollectionNewRutinamaquina = em.merge(rutinamaquinaCollectionNewRutinamaquina);
                    if (oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina != null && !oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina.equals(maquinas)) {
                        oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina.getRutinamaquinaCollection().remove(rutinamaquinaCollectionNewRutinamaquina);
                        oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina = em.merge(oldMaquinasOfRutinamaquinaCollectionNewRutinamaquina);
                    }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Rutinamaquina> rutinamaquinaCollectionOrphanCheck = maquinas.getRutinamaquinaCollection();
            for (Rutinamaquina rutinamaquinaCollectionOrphanCheckRutinamaquina : rutinamaquinaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Maquinas (" + maquinas + ") cannot be destroyed since the Rutinamaquina " + rutinamaquinaCollectionOrphanCheckRutinamaquina + " in its rutinamaquinaCollection field has a non-nullable maquinas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
