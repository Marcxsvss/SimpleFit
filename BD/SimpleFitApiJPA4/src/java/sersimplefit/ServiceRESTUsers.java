package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import simplefit.Users;
import simplefit.UsersJpaController;

@Path("service")
public class ServiceRESTUsers {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPA4PU";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {

        return Response
                .status(Response.Status.OK)
                .entity("{ \"mensaje\": \"Funciona correctamente\" }")
                .build();
    }

    @GET
    @Path("/dni/{dni}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDni(@PathParam("dni") String dni) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

        UsersJpaController dao = new UsersJpaController(emf);
        Users usuario = dao.findUsersByDni(dni);
        emf.close();
        Response response;
        response = Response
                .status(Response.Status.OK)
                .entity(usuario)
                .build();
        return response;
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@PathParam("email") String email) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        List<Users> lista = null;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            UsersJpaController dao = new UsersJpaController(emf);
            EntityManager em = dao.getEntityManager();
            TypedQuery<Users> consultaRegistros
                    = em.createNamedQuery("Users.findByEmail", Users.class);
            lista = consultaRegistros.setParameter("email", email).getResultList();
            if ((lista != null) && (!lista.isEmpty())) {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(lista)
                        .build();
            } else {
                statusResul = Response.Status.NO_CONTENT;
                response = Response
                        .status(statusResul)
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
    @Path("/login")
    public Response login(
        @QueryParam("email") String email,
        @QueryParam("password") String password
    ) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            em = emf.createEntityManager();

            // Consultar la base de datos para verificar el email y la contraseña
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM Users u WHERE u.email = :email AND u.password = :password",
                Long.class
            );
            query.setParameter("email", email);
            query.setParameter("password", password);
            Long count = query.getSingleResult();

            if (count > 0) {
                return Response.ok().entity(true).build();
            } else {
                return Response.ok().entity(false).build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(false).build();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

}
