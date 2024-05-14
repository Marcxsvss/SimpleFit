/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Rutinamaquina;
import jpasimplefit.RutinamaquinaJpaController;


@Path("rutinamaquina")
public class ServiceRESTRutinaMaquina {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPA1.1PU";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTRutinaMaquina
     */
    public ServiceRESTRutinaMaquina() {
    }

    @GET
    @Path("{rutinaid}/{dia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("rutinaid") Integer rutinaid, @PathParam("dia") String dia) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        List<Rutinamaquina> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            RutinamaquinaJpaController dao = new RutinamaquinaJpaController(emf);
            EntityManager em = dao.getEntityManager();
            TypedQuery<Rutinamaquina> consultaRegistros
                    = em.createNamedQuery("Rutinamaquina.findMaquinas", Rutinamaquina.class);
            lista = consultaRegistros.setParameter("rutinaid", rutinaid).setParameter("dia", dia).getResultList();
        
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

    /**
     * Retrieves representation of an instance of
     * sersimplefit.ServiceRESTRutinaMaquina
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of
     * ServiceRESTRutinaMaquina
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
