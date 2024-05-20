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
import simplefitjpa.exceptions.NonexistentEntityException;
import simplefitjpa.exceptions.PreexistingEntityException;

/**
 *
 * @author marki
 */
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) throws PreexistingEntityException, Exception {
        if (usuarios.getRutinasCollection() == null) {
            usuarios.setRutinasCollection(new ArrayList<Rutinas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rutinas> attachedRutinasCollection = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionRutinasToAttach : usuarios.getRutinasCollection()) {
                rutinasCollectionRutinasToAttach = em.getReference(rutinasCollectionRutinasToAttach.getClass(), rutinasCollectionRutinasToAttach.getRutinaid());
                attachedRutinasCollection.add(rutinasCollectionRutinasToAttach);
            }
            usuarios.setRutinasCollection(attachedRutinasCollection);
            em.persist(usuarios);
            for (Rutinas rutinasCollectionRutinas : usuarios.getRutinasCollection()) {
                rutinasCollectionRutinas.getUsuariosCollection().add(usuarios);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarios(usuarios.getEmail()) != null) {
                throw new PreexistingEntityException("Usuarios " + usuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getEmail());
            Collection<Rutinas> rutinasCollectionOld = persistentUsuarios.getRutinasCollection();
            Collection<Rutinas> rutinasCollectionNew = usuarios.getRutinasCollection();
            Collection<Rutinas> attachedRutinasCollectionNew = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionNewRutinasToAttach : rutinasCollectionNew) {
                rutinasCollectionNewRutinasToAttach = em.getReference(rutinasCollectionNewRutinasToAttach.getClass(), rutinasCollectionNewRutinasToAttach.getRutinaid());
                attachedRutinasCollectionNew.add(rutinasCollectionNewRutinasToAttach);
            }
            rutinasCollectionNew = attachedRutinasCollectionNew;
            usuarios.setRutinasCollection(rutinasCollectionNew);
            usuarios = em.merge(usuarios);
            for (Rutinas rutinasCollectionOldRutinas : rutinasCollectionOld) {
                if (!rutinasCollectionNew.contains(rutinasCollectionOldRutinas)) {
                    rutinasCollectionOldRutinas.getUsuariosCollection().remove(usuarios);
                    rutinasCollectionOldRutinas = em.merge(rutinasCollectionOldRutinas);
                }
            }
            for (Rutinas rutinasCollectionNewRutinas : rutinasCollectionNew) {
                if (!rutinasCollectionOld.contains(rutinasCollectionNewRutinas)) {
                    rutinasCollectionNewRutinas.getUsuariosCollection().add(usuarios);
                    rutinasCollectionNewRutinas = em.merge(rutinasCollectionNewRutinas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuarios.getEmail();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getEmail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            Collection<Rutinas> rutinasCollection = usuarios.getRutinasCollection();
            for (Rutinas rutinasCollectionRutinas : rutinasCollection) {
                rutinasCollectionRutinas.getUsuariosCollection().remove(usuarios);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
