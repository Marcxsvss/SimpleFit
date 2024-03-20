/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import simplefit.exceptions.NonexistentEntityException;
import simplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class DietaalimentoJpaController implements Serializable {

    public DietaalimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dietaalimento dietaalimento) throws PreexistingEntityException, Exception {
        if (dietaalimento.getDietaalimentoPK() == null) {
            dietaalimento.setDietaalimentoPK(new DietaalimentoPK());
        }
        dietaalimento.getDietaalimentoPK().setDietaid(dietaalimento.getDietas().getDietaid());
        dietaalimento.getDietaalimentoPK().setAlimentoid(dietaalimento.getAlimentos().getAlimentoid());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alimentos alimentos = dietaalimento.getAlimentos();
            if (alimentos != null) {
                alimentos = em.getReference(alimentos.getClass(), alimentos.getAlimentoid());
                dietaalimento.setAlimentos(alimentos);
            }
            Dietas dietas = dietaalimento.getDietas();
            if (dietas != null) {
                dietas = em.getReference(dietas.getClass(), dietas.getDietaid());
                dietaalimento.setDietas(dietas);
            }
            em.persist(dietaalimento);
            if (alimentos != null) {
                alimentos.getDietaalimentoCollection().add(dietaalimento);
                alimentos = em.merge(alimentos);
            }
            if (dietas != null) {
                dietas.getDietaalimentoCollection().add(dietaalimento);
                dietas = em.merge(dietas);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDietaalimento(dietaalimento.getDietaalimentoPK()) != null) {
                throw new PreexistingEntityException("Dietaalimento " + dietaalimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dietaalimento dietaalimento) throws NonexistentEntityException, Exception {
        dietaalimento.getDietaalimentoPK().setDietaid(dietaalimento.getDietas().getDietaid());
        dietaalimento.getDietaalimentoPK().setAlimentoid(dietaalimento.getAlimentos().getAlimentoid());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dietaalimento persistentDietaalimento = em.find(Dietaalimento.class, dietaalimento.getDietaalimentoPK());
            Alimentos alimentosOld = persistentDietaalimento.getAlimentos();
            Alimentos alimentosNew = dietaalimento.getAlimentos();
            Dietas dietasOld = persistentDietaalimento.getDietas();
            Dietas dietasNew = dietaalimento.getDietas();
            if (alimentosNew != null) {
                alimentosNew = em.getReference(alimentosNew.getClass(), alimentosNew.getAlimentoid());
                dietaalimento.setAlimentos(alimentosNew);
            }
            if (dietasNew != null) {
                dietasNew = em.getReference(dietasNew.getClass(), dietasNew.getDietaid());
                dietaalimento.setDietas(dietasNew);
            }
            dietaalimento = em.merge(dietaalimento);
            if (alimentosOld != null && !alimentosOld.equals(alimentosNew)) {
                alimentosOld.getDietaalimentoCollection().remove(dietaalimento);
                alimentosOld = em.merge(alimentosOld);
            }
            if (alimentosNew != null && !alimentosNew.equals(alimentosOld)) {
                alimentosNew.getDietaalimentoCollection().add(dietaalimento);
                alimentosNew = em.merge(alimentosNew);
            }
            if (dietasOld != null && !dietasOld.equals(dietasNew)) {
                dietasOld.getDietaalimentoCollection().remove(dietaalimento);
                dietasOld = em.merge(dietasOld);
            }
            if (dietasNew != null && !dietasNew.equals(dietasOld)) {
                dietasNew.getDietaalimentoCollection().add(dietaalimento);
                dietasNew = em.merge(dietasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DietaalimentoPK id = dietaalimento.getDietaalimentoPK();
                if (findDietaalimento(id) == null) {
                    throw new NonexistentEntityException("The dietaalimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DietaalimentoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dietaalimento dietaalimento;
            try {
                dietaalimento = em.getReference(Dietaalimento.class, id);
                dietaalimento.getDietaalimentoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dietaalimento with id " + id + " no longer exists.", enfe);
            }
            Alimentos alimentos = dietaalimento.getAlimentos();
            if (alimentos != null) {
                alimentos.getDietaalimentoCollection().remove(dietaalimento);
                alimentos = em.merge(alimentos);
            }
            Dietas dietas = dietaalimento.getDietas();
            if (dietas != null) {
                dietas.getDietaalimentoCollection().remove(dietaalimento);
                dietas = em.merge(dietas);
            }
            em.remove(dietaalimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dietaalimento> findDietaalimentoEntities() {
        return findDietaalimentoEntities(true, -1, -1);
    }

    public List<Dietaalimento> findDietaalimentoEntities(int maxResults, int firstResult) {
        return findDietaalimentoEntities(false, maxResults, firstResult);
    }

    private List<Dietaalimento> findDietaalimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dietaalimento.class));
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

    public Dietaalimento findDietaalimento(DietaalimentoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dietaalimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDietaalimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dietaalimento> rt = cq.from(Dietaalimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
