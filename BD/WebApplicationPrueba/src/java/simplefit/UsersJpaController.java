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
public class UsersJpaController implements Serializable {

    public UsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) throws PreexistingEntityException, Exception {
        if (users.getRutinasCollection() == null) {
            users.setRutinasCollection(new ArrayList<Rutinas>());
        }
        if (users.getDietasCollection() == null) {
            users.setDietasCollection(new ArrayList<Dietas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rutinas> attachedRutinasCollection = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionRutinasToAttach : users.getRutinasCollection()) {
                rutinasCollectionRutinasToAttach = em.getReference(rutinasCollectionRutinasToAttach.getClass(), rutinasCollectionRutinasToAttach.getRutinaid());
                attachedRutinasCollection.add(rutinasCollectionRutinasToAttach);
            }
            users.setRutinasCollection(attachedRutinasCollection);
            Collection<Dietas> attachedDietasCollection = new ArrayList<Dietas>();
            for (Dietas dietasCollectionDietasToAttach : users.getDietasCollection()) {
                dietasCollectionDietasToAttach = em.getReference(dietasCollectionDietasToAttach.getClass(), dietasCollectionDietasToAttach.getDietaid());
                attachedDietasCollection.add(dietasCollectionDietasToAttach);
            }
            users.setDietasCollection(attachedDietasCollection);
            em.persist(users);
            for (Rutinas rutinasCollectionRutinas : users.getRutinasCollection()) {
                Users oldUseridOfRutinasCollectionRutinas = rutinasCollectionRutinas.getUserid();
                rutinasCollectionRutinas.setUserid(users);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
                if (oldUseridOfRutinasCollectionRutinas != null) {
                    oldUseridOfRutinasCollectionRutinas.getRutinasCollection().remove(rutinasCollectionRutinas);
                    oldUseridOfRutinasCollectionRutinas = em.merge(oldUseridOfRutinasCollectionRutinas);
                }
            }
            for (Dietas dietasCollectionDietas : users.getDietasCollection()) {
                Users oldUseridOfDietasCollectionDietas = dietasCollectionDietas.getUserid();
                dietasCollectionDietas.setUserid(users);
                dietasCollectionDietas = em.merge(dietasCollectionDietas);
                if (oldUseridOfDietasCollectionDietas != null) {
                    oldUseridOfDietasCollectionDietas.getDietasCollection().remove(dietasCollectionDietas);
                    oldUseridOfDietasCollectionDietas = em.merge(oldUseridOfDietasCollectionDietas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsers(users.getDni()) != null) {
                throw new PreexistingEntityException("Users " + users + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Users users) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getDni());
            Collection<Rutinas> rutinasCollectionOld = persistentUsers.getRutinasCollection();
            Collection<Rutinas> rutinasCollectionNew = users.getRutinasCollection();
            Collection<Dietas> dietasCollectionOld = persistentUsers.getDietasCollection();
            Collection<Dietas> dietasCollectionNew = users.getDietasCollection();
            Collection<Rutinas> attachedRutinasCollectionNew = new ArrayList<Rutinas>();
            for (Rutinas rutinasCollectionNewRutinasToAttach : rutinasCollectionNew) {
                rutinasCollectionNewRutinasToAttach = em.getReference(rutinasCollectionNewRutinasToAttach.getClass(), rutinasCollectionNewRutinasToAttach.getRutinaid());
                attachedRutinasCollectionNew.add(rutinasCollectionNewRutinasToAttach);
            }
            rutinasCollectionNew = attachedRutinasCollectionNew;
            users.setRutinasCollection(rutinasCollectionNew);
            Collection<Dietas> attachedDietasCollectionNew = new ArrayList<Dietas>();
            for (Dietas dietasCollectionNewDietasToAttach : dietasCollectionNew) {
                dietasCollectionNewDietasToAttach = em.getReference(dietasCollectionNewDietasToAttach.getClass(), dietasCollectionNewDietasToAttach.getDietaid());
                attachedDietasCollectionNew.add(dietasCollectionNewDietasToAttach);
            }
            dietasCollectionNew = attachedDietasCollectionNew;
            users.setDietasCollection(dietasCollectionNew);
            users = em.merge(users);
            for (Rutinas rutinasCollectionOldRutinas : rutinasCollectionOld) {
                if (!rutinasCollectionNew.contains(rutinasCollectionOldRutinas)) {
                    rutinasCollectionOldRutinas.setUserid(null);
                    rutinasCollectionOldRutinas = em.merge(rutinasCollectionOldRutinas);
                }
            }
            for (Rutinas rutinasCollectionNewRutinas : rutinasCollectionNew) {
                if (!rutinasCollectionOld.contains(rutinasCollectionNewRutinas)) {
                    Users oldUseridOfRutinasCollectionNewRutinas = rutinasCollectionNewRutinas.getUserid();
                    rutinasCollectionNewRutinas.setUserid(users);
                    rutinasCollectionNewRutinas = em.merge(rutinasCollectionNewRutinas);
                    if (oldUseridOfRutinasCollectionNewRutinas != null && !oldUseridOfRutinasCollectionNewRutinas.equals(users)) {
                        oldUseridOfRutinasCollectionNewRutinas.getRutinasCollection().remove(rutinasCollectionNewRutinas);
                        oldUseridOfRutinasCollectionNewRutinas = em.merge(oldUseridOfRutinasCollectionNewRutinas);
                    }
                }
            }
            for (Dietas dietasCollectionOldDietas : dietasCollectionOld) {
                if (!dietasCollectionNew.contains(dietasCollectionOldDietas)) {
                    dietasCollectionOldDietas.setUserid(null);
                    dietasCollectionOldDietas = em.merge(dietasCollectionOldDietas);
                }
            }
            for (Dietas dietasCollectionNewDietas : dietasCollectionNew) {
                if (!dietasCollectionOld.contains(dietasCollectionNewDietas)) {
                    Users oldUseridOfDietasCollectionNewDietas = dietasCollectionNewDietas.getUserid();
                    dietasCollectionNewDietas.setUserid(users);
                    dietasCollectionNewDietas = em.merge(dietasCollectionNewDietas);
                    if (oldUseridOfDietasCollectionNewDietas != null && !oldUseridOfDietasCollectionNewDietas.equals(users)) {
                        oldUseridOfDietasCollectionNewDietas.getDietasCollection().remove(dietasCollectionNewDietas);
                        oldUseridOfDietasCollectionNewDietas = em.merge(oldUseridOfDietasCollectionNewDietas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getDni();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
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
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            Collection<Rutinas> rutinasCollection = users.getRutinasCollection();
            for (Rutinas rutinasCollectionRutinas : rutinasCollection) {
                rutinasCollectionRutinas.setUserid(null);
                rutinasCollectionRutinas = em.merge(rutinasCollectionRutinas);
            }
            Collection<Dietas> dietasCollection = users.getDietasCollection();
            for (Dietas dietasCollectionDietas : dietasCollection) {
                dietasCollectionDietas.setUserid(null);
                dietasCollectionDietas = em.merge(dietasCollectionDietas);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
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

    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
