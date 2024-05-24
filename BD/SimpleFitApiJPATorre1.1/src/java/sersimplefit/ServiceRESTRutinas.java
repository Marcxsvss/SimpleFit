/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Rutinamaquina;
import jpasimplefit.RutinamaquinaJpaController;
import jpasimplefit.RutinamaquinaPK;
import jpasimplefit.Rutinas;
import jpasimplefit.RutinasJpaController;
import jpasimplefit.Usuarios;
import jpasimplefit.UsuariosJpaController;

@Path("rutinas")
public class ServiceRESTRutinas {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPATorre1.1PU";

    public ServiceRESTRutinas() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") Integer id) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        Rutinas rutina;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            RutinasJpaController dao = new RutinasJpaController(emf);
            rutina = dao.findRutinas(id);

            if (rutina == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe usuario con ID " + id);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(rutina)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(ex.getMessage())
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
        List<Rutinas> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            RutinasJpaController dao = new RutinasJpaController(emf);
            lista = dao.findRutinasEntities();
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

    /*@Path("/delete/{rutinaid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("rutinaid") int rutinaid) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();

            RutinasJpaController rutinasController = new RutinasJpaController(emf);
            Rutinas rutina = rutinasController.findRutinas(rutinaid);

            if (rutina == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe rutina con id " + rutinaid);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                // Eliminamos todos los registros en la tabla Rutinamaquina asociados a esta rutina
                List<Rutinamaquina> rutinamaquinaList = (List<Rutinamaquina>) rutina.getRutinamaquinaCollection();
                for (Rutinamaquina rutinamaquina : rutinamaquinaList) {
                    em.remove(em.merge(rutinamaquina));
                }

                // Ahora podemos eliminar la rutina
                rutinasController.destroy(rutinaid);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Rutina con ID " + rutinaid + " eliminada correctamente");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición: " + ex.getMessage());
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
    }*/
    @DELETE
    @Path("/delete/{rutinaid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("rutinaid") int rutinaid) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        List<Rutinas> rutina;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();
            
            RutinasJpaController dao = new RutinasJpaController(emf);
            TypedQuery<Rutinas> consultaRegistros
                    = em.createNamedQuery("Rutinas.findByRutinaid", Rutinas.class);
            rutina = consultaRegistros.setParameter("rutinaid", rutinaid).getResultList();
            

            if (rutina.size() == 0) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe rutina con id " + rutinaid);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.destroy(rutinaid);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Rutina con ID " + rutinaid + " eliminado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición" + ex.getLocalizedMessage() + ex.getMessage());
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
