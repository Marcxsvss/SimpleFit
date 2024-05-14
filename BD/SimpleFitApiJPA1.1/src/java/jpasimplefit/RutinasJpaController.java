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
import jpasimplefit.exceptions.IllegalOrphanException;
import jpasimplefit.exceptions.NonexistentEntityException;
import jpasimplefit.exceptions.PreexistingEntityException;

/**
 *
 * @author Marcos
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
        if (rutinas.getUsuariosCollection() == null) {
            rutinas.setUsuariosCollection(new ArrayList<Usuarios>());
        }
        if (rutinas.getRutinamaquinaCollection() == null) {
            rutinas.setRutinamaquinaCollection(new ArrayList<Rutinamaquina>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuarios> attachedUsuariosCollection = new ArrayList<Usuarios>();
            for (Usuarios usuariosCollectionUsuariosToAttach : rutinas.getUsuariosCollection()) {
                usuariosCollectionUsuariosToAttach = em.getReference(usuariosCollectionUsuariosToAttach.getClass(), usuariosCollectionUsuariosToAttach.getEmail());
                attachedUsuariosCollection.add(usuariosCollectionUsuariosToAttach);
            }
            rutinas.setUsuariosCollection(attachedUsuariosCollection);
            Collection<Rutinamaquina> attachedRutinamaquinaCollection = new ArrayList<Rutinamaquina>();
            for (Rutinamaquina rutinamaquinaCollectionRutinamaquinaToAttach : rutinas.getRutinamaquinaCollection()) {
                rutinamaquinaCollectionRutinamaquinaToAttach = em.getReference(rutinamaquinaCollectionRutinamaquinaToAttach.getClass(), rutinamaquinaCollectionRutinamaquinaToAttach.getRutinamaquinaPK());
                attachedRutinamaquinaCollection.add(rutinamaquinaCollectionRutinamaquinaToAttach);
            }
            rutinas.setRutinamaquinaCollection(attachedRutinamaquinaCollection);
            em.persist(rutinas);
            for (Usuarios usuariosCollectionUsuarios : rutinas.getUsuariosCollection()) {
                usuariosCollectionUsuarios.getRutinasCollection().add(rutinas);
                usuariosCollectionUsuarios = em.merge(usuariosCollectionUsuarios);
            }
            for (Rutinamaquina rutinamaquinaCollectionRutinamaquina : rutinas.getRutinamaquinaCollection()) {
                Rutinas oldRutinasOfRutinamaquinaCollectionRutinamaquina = rutinamaquinaCollectionRutinamaquina.getRutinas();
                rutinamaquinaCollectionRutinamaquina.setRutinas(rutinas);
                rutinamaquinaCollectionRutinamaquina = em.merge(rutinamaquinaCollectionRutinamaquina);
                if (oldRutinasOfRutinamaquinaCollectionRutinamaquina != null) {
                    oldRutinasOfRutinamaquinaCollectionRutinamaquina.getRutinamaquinaCollection().remove(rutinamaquinaCollectionRutinamaquina);
                    oldRutinasOfRutinamaquinaCollectionRutinamaquina = em.merge(oldRutinasOfRutinamaquinaCollectionRutinamaquina);
                }
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

    public void edit(Rutinas rutinas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutinas persistentRutinas = em.find(Rutinas.class, rutinas.getRutinaid());
            Collection<Usuarios> usuariosCollectionOld = persistentRutinas.getUsuariosCollection();
            Collection<Usuarios> usuariosCollectionNew = rutinas.getUsuariosCollection();
            Collection<Rutinamaquina> rutinamaquinaCollectionOld = persistentRutinas.getRutinamaquinaCollection();
            Collection<Rutinamaquina> rutinamaquinaCollectionNew = rutinas.getRutinamaquinaCollection();
            List<String> illegalOrphanMessages = null;
            for (Rutinamaquina rutinamaquinaCollectionOldRutinamaquina : rutinamaquinaCollectionOld) {
                if (!rutinamaquinaCollectionNew.contains(rutinamaquinaCollectionOldRutinamaquina)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rutinamaquina " + rutinamaquinaCollectionOldRutinamaquina + " since its rutinas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Usuarios> attachedUsuariosCollectionNew = new ArrayList<Usuarios>();
            for (Usuarios usuariosCollectionNewUsuariosToAttach : usuariosCollectionNew) {
                usuariosCollectionNewUsuariosToAttach = em.getReference(usuariosCollectionNewUsuariosToAttach.getClass(), usuariosCollectionNewUsuariosToAttach.getEmail());
                attachedUsuariosCollectionNew.add(usuariosCollectionNewUsuariosToAttach);
            }
            usuariosCollectionNew = attachedUsuariosCollectionNew;
            rutinas.setUsuariosCollection(usuariosCollectionNew);
            Collection<Rutinamaquina> attachedRutinamaquinaCollectionNew = new ArrayList<Rutinamaquina>();
            for (Rutinamaquina rutinamaquinaCollectionNewRutinamaquinaToAttach : rutinamaquinaCollectionNew) {
                rutinamaquinaCollectionNewRutinamaquinaToAttach = em.getReference(rutinamaquinaCollectionNewRutinamaquinaToAttach.getClass(), rutinamaquinaCollectionNewRutinamaquinaToAttach.getRutinamaquinaPK());
                attachedRutinamaquinaCollectionNew.add(rutinamaquinaCollectionNewRutinamaquinaToAttach);
            }
            rutinamaquinaCollectionNew = attachedRutinamaquinaCollectionNew;
            rutinas.setRutinamaquinaCollection(rutinamaquinaCollectionNew);
            rutinas = em.merge(rutinas);
            for (Usuarios usuariosCollectionOldUsuarios : usuariosCollectionOld) {
                if (!usuariosCollectionNew.contains(usuariosCollectionOldUsuarios)) {
                    usuariosCollectionOldUsuarios.getRutinasCollection().remove(rutinas);
                    usuariosCollectionOldUsuarios = em.merge(usuariosCollectionOldUsuarios);
                }
            }
            for (Usuarios usuariosCollectionNewUsuarios : usuariosCollectionNew) {
                if (!usuariosCollectionOld.contains(usuariosCollectionNewUsuarios)) {
                    usuariosCollectionNewUsuarios.getRutinasCollection().add(rutinas);
                    usuariosCollectionNewUsuarios = em.merge(usuariosCollectionNewUsuarios);
                }
            }
            for (Rutinamaquina rutinamaquinaCollectionNewRutinamaquina : rutinamaquinaCollectionNew) {
                if (!rutinamaquinaCollectionOld.contains(rutinamaquinaCollectionNewRutinamaquina)) {
                    Rutinas oldRutinasOfRutinamaquinaCollectionNewRutinamaquina = rutinamaquinaCollectionNewRutinamaquina.getRutinas();
                    rutinamaquinaCollectionNewRutinamaquina.setRutinas(rutinas);
                    rutinamaquinaCollectionNewRutinamaquina = em.merge(rutinamaquinaCollectionNewRutinamaquina);
                    if (oldRutinasOfRutinamaquinaCollectionNewRutinamaquina != null && !oldRutinasOfRutinamaquinaCollectionNewRutinamaquina.equals(rutinas)) {
                        oldRutinasOfRutinamaquinaCollectionNewRutinamaquina.getRutinamaquinaCollection().remove(rutinamaquinaCollectionNewRutinamaquina);
                        oldRutinasOfRutinamaquinaCollectionNewRutinamaquina = em.merge(oldRutinasOfRutinamaquinaCollectionNewRutinamaquina);
                    }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Rutinamaquina> rutinamaquinaCollectionOrphanCheck = rutinas.getRutinamaquinaCollection();
            for (Rutinamaquina rutinamaquinaCollectionOrphanCheckRutinamaquina : rutinamaquinaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rutinas (" + rutinas + ") cannot be destroyed since the Rutinamaquina " + rutinamaquinaCollectionOrphanCheckRutinamaquina + " in its rutinamaquinaCollection field has a non-nullable rutinas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Usuarios> usuariosCollection = rutinas.getUsuariosCollection();
            for (Usuarios usuariosCollectionUsuarios : usuariosCollection) {
                usuariosCollectionUsuarios.getRutinasCollection().remove(rutinas);
                usuariosCollectionUsuarios = em.merge(usuariosCollectionUsuarios);
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
