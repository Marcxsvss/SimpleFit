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
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpasimplefit.exceptions.NonexistentEntityException;
import jpasimplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author Marcos
 */
public class RutinamaquinaJpaController implements Serializable {

    public RutinamaquinaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rutinamaquina rutinamaquina) throws PreexistingEntityException, Exception {
        if (rutinamaquina.getRutinamaquinaPK() == null) {
            rutinamaquina.setRutinamaquinaPK(new RutinamaquinaPK());
        }
        rutinamaquina.getRutinamaquinaPK().setRutinaid(rutinamaquina.getRutinas().getRutinaid());
        rutinamaquina.getRutinamaquinaPK().setMaquinaid(rutinamaquina.getMaquinas().getMaquinaid());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas maquinas = rutinamaquina.getMaquinas();
            if (maquinas != null) {
                maquinas = em.getReference(maquinas.getClass(), maquinas.getMaquinaid());
                rutinamaquina.setMaquinas(maquinas);
            }
            Rutinas rutinas = rutinamaquina.getRutinas();
            if (rutinas != null) {
                rutinas = em.getReference(rutinas.getClass(), rutinas.getRutinaid());
                rutinamaquina.setRutinas(rutinas);
            }
            em.persist(rutinamaquina);
            if (maquinas != null) {
                maquinas.getRutinamaquinaCollection().add(rutinamaquina);
                maquinas = em.merge(maquinas);
            }
            if (rutinas != null) {
                rutinas.getRutinamaquinaCollection().add(rutinamaquina);
                rutinas = em.merge(rutinas);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutinamaquina(rutinamaquina.getRutinamaquinaPK()) != null) {
                throw new PreexistingEntityException("Rutinamaquina " + rutinamaquina + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rutinamaquina rutinamaquina) throws NonexistentEntityException, Exception {
        rutinamaquina.getRutinamaquinaPK().setRutinaid(rutinamaquina.getRutinas().getRutinaid());
        rutinamaquina.getRutinamaquinaPK().setMaquinaid(rutinamaquina.getMaquinas().getMaquinaid());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutinamaquina persistentRutinamaquina = em.find(Rutinamaquina.class, rutinamaquina.getRutinamaquinaPK());
            Maquinas maquinasOld = persistentRutinamaquina.getMaquinas();
            Maquinas maquinasNew = rutinamaquina.getMaquinas();
            Rutinas rutinasOld = persistentRutinamaquina.getRutinas();
            Rutinas rutinasNew = rutinamaquina.getRutinas();
            if (maquinasNew != null) {
                maquinasNew = em.getReference(maquinasNew.getClass(), maquinasNew.getMaquinaid());
                rutinamaquina.setMaquinas(maquinasNew);
            }
            if (rutinasNew != null) {
                rutinasNew = em.getReference(rutinasNew.getClass(), rutinasNew.getRutinaid());
                rutinamaquina.setRutinas(rutinasNew);
            }
            rutinamaquina = em.merge(rutinamaquina);
            if (maquinasOld != null && !maquinasOld.equals(maquinasNew)) {
                maquinasOld.getRutinamaquinaCollection().remove(rutinamaquina);
                maquinasOld = em.merge(maquinasOld);
            }
            if (maquinasNew != null && !maquinasNew.equals(maquinasOld)) {
                maquinasNew.getRutinamaquinaCollection().add(rutinamaquina);
                maquinasNew = em.merge(maquinasNew);
            }
            if (rutinasOld != null && !rutinasOld.equals(rutinasNew)) {
                rutinasOld.getRutinamaquinaCollection().remove(rutinamaquina);
                rutinasOld = em.merge(rutinasOld);
            }
            if (rutinasNew != null && !rutinasNew.equals(rutinasOld)) {
                rutinasNew.getRutinamaquinaCollection().add(rutinamaquina);
                rutinasNew = em.merge(rutinasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RutinamaquinaPK id = rutinamaquina.getRutinamaquinaPK();
                if (findRutinamaquina(id) == null) {
                    throw new NonexistentEntityException("The rutinamaquina with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RutinamaquinaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutinamaquina rutinamaquina;
            try {
                rutinamaquina = em.getReference(Rutinamaquina.class, id);
                rutinamaquina.getRutinamaquinaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutinamaquina with id " + id + " no longer exists.", enfe);
            }
            Maquinas maquinas = rutinamaquina.getMaquinas();
            if (maquinas != null) {
                maquinas.getRutinamaquinaCollection().remove(rutinamaquina);
                maquinas = em.merge(maquinas);
            }
            Rutinas rutinas = rutinamaquina.getRutinas();
            if (rutinas != null) {
                rutinas.getRutinamaquinaCollection().remove(rutinamaquina);
                rutinas = em.merge(rutinas);
            }
            em.remove(rutinamaquina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rutinamaquina> findRutinamaquinaEntities() {
        return findRutinamaquinaEntities(true, -1, -1);
    }

    public List<Rutinamaquina> findRutinamaquinaEntities(int maxResults, int firstResult) {
        return findRutinamaquinaEntities(false, maxResults, firstResult);
    }

    private List<Rutinamaquina> findRutinamaquinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rutinamaquina.class));
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

    public Rutinamaquina findRutinamaquina(RutinamaquinaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rutinamaquina.class, id);
        } finally {
            em.close();
        }
    }
    public List<Integer> findMaquinas(Integer rutinaid,String dia) {
        EntityManager em = getEntityManager();
        TypedQuery<Integer> consultaMaquinas = em.createQuery(
            "SELECT r.maquinaid FROM Rutinamaquina r WHERE r.rutinamaquinaPK.rutinaid = :rutinaid AND r.rutinamaquinaPK.dia = :dia", Integer.class);
       List<Integer> maquinas = consultaMaquinas.setParameter("rutinaid", rutinaid)
                                        .setParameter("dia", dia)
                                        .getResultList();
        return maquinas; // Suponiendo que el email es único
    }

    public int getRutinamaquinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rutinamaquina> rt = cq.from(Rutinamaquina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
