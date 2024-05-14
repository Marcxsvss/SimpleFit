/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import simplefit.Rutinamaquina;
import simplefit.RutinamaquinaJpaController;

/**
 * REST Web Service
 *
 * @author marki
 */
@Path("rutinamaquina")
public class ServiceRESTRutinamaquina {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPAPortatilPU";
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTRutinamaquina
     */
    public ServiceRESTRutinamaquina() {
    }

    @GET
    @Path("{rutinaid}/{dia}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
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
}
