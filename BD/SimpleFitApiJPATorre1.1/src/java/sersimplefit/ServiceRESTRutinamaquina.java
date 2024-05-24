package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;


@Path("rutinamaquina")
public class ServiceRESTRutinamaquina {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPATorre1.1PU";

    public ServiceRESTRutinamaquina() {
    }

    @GET
    @Path("{rutinaid}/{dia}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("rutinaid") Integer rutinaid,@PathParam("dia") String dia) { //Maquinas de una rutina un dia en concreto
        EntityManagerFactory emf = null;

        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
       
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Rutinamaquina.findByRutinaidAndDia");
            query.setParameter("rutinaid", rutinaid);
            query.setParameter("dia", dia);
            List<Integer> maquinaIds = query.getResultList(); //Nos devuelve una lista de enteros que corresponderán a la id de

            if (maquinaIds == null) { //Si no devuelve nada, nos infromará de que no existe ninguna rutina con ese id
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe rutina con ID " + rutinaid);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else { //En caso de que devuelva registros, recojerá los datos.
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(maquinaIds)
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
}
