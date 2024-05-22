package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Rutinas;
import jpasimplefit.Usuarios;
import jpasimplefit.UsuariosJpaController;

/**
 * REST Web Service
 *
 * @author Marcos
 */
@Path("usuarios")
public class ServiceRESTUsuarios {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPATorre1.1PU";

    public ServiceRESTUsuarios() {
    }

    @GET
    @Path("{mail}/rutinas") //Devuelve las rutinas que tiene un usuario
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRutinas(@PathParam("mail") String email) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        List<Rutinas> lista;
        Usuarios usu;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();

            TypedQuery<Usuarios> consultaRegistros
                    = em.createNamedQuery("Usuarios.findByEmail", Usuarios.class);
            usu = consultaRegistros.setParameter("email", email).getSingleResult();
            lista = (List<Rutinas>) usu.getRutinasCollection();
            if (lista == null) {
                statusResul = Response.Status.NO_CONTENT;
                response = Response
                        .status(statusResul)
                        .build();
            } else {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(lista)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @GET
    @Path("{mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("mail") String email) {
        EntityManagerFactory emf = null;

        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        Usuarios usu;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();

            TypedQuery<Usuarios> consultaRegistros
                    = em.createNamedQuery("Usuarios.findByEmail", Usuarios.class);
            usu = consultaRegistros.setParameter("email", email).getSingleResult();

            if (usu == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe usuario con ID " + email);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(usu)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", ex.getMessage());
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        List<Usuarios> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            UsuariosJpaController dao = new UsuariosJpaController(emf);
            lista = dao.findUsuariosEntities();
            if (lista == null) {
                statusResul = Response.Status.NO_CONTENT;
                response = Response
                        .status(statusResul)
                        .build();
            } else {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(lista)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Usuarios usu) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            UsuariosJpaController dao = new UsuariosJpaController(emf);
            Usuarios usuFound = null;
            if ((!"".equals(usu.getEmail())) && (usu.getEmail() != null)) {
                usuFound = dao.findUsuarios(usu.getEmail());
            }
            if (usuFound != null) {
                statusResul = Response.Status.FOUND;
                mensaje.put("mensaje", "Ya existe usuario con email " + usu.getEmail());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.create(usu);
                statusResul = Response.Status.CREATED;
                mensaje.put("mensaje", "Usuario " + usu.getEmail() + " grabado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Usuarios usu) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            UsuariosJpaController dao = new UsuariosJpaController(emf);
            Usuarios usuFound = dao.findUsuarios(usu.getEmail());
            if (usuFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe usuario con ID " + usu.getEmail());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                // Actualizar campos del libro encontrado
                usuFound.setEdad(usu.getEdad());
                usuFound.setAltura(usu.getAltura());
                usuFound.setSexo(usu.getSexo());
                usuFound.setRutinastate(usu.getRutinastate());
                usuFound.setSomatotipo(usu.getSomatotipo());
                usuFound.setPeso(usu.getPeso());
                usuFound.setAcceso(usu.getAcceso());
                // Grabar los cambios
                dao.edit(usuFound);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Usuario con ID " + usu.getEmail() + " actualizado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @DELETE
    @Path("/delete/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("email") String email) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        List<Usuarios> usu;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();
            UsuariosJpaController dao = new UsuariosJpaController(emf);
            TypedQuery<Usuarios> consultaRegistros
                    = em.createNamedQuery("Usuarios.findByEmail", Usuarios.class);
            usu = consultaRegistros.setParameter("email", email).getResultList();
            

            if (usu.size() == 0) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No usuario con email " + email);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.destroy(email);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Usuario con ID " + email + " eliminado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

}
