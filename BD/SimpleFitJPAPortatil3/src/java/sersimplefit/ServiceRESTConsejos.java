package sersimplefit;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Consejos;
import jpasimplefit.ConsejosJpaController;

/**
 * REST Web Service
 *
 * @author Marcos
 */
@Path("consejos")
public class ServiceRESTConsejos {
    private static final String PERSISTENCE_UNIT = "SimpleFitJPAPortatil3PU";
   
    public ServiceRESTConsejos() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Response.Status statusResul;
        List<Consejos> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            ConsejosJpaController dao = new ConsejosJpaController(emf);
            lista = dao.findConsejosEntities();
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
