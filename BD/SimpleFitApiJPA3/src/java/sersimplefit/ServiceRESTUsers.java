package sersimplefit;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import simplefit.Users;
import simplefit.UsersJpaController;

@Path("service")
public class ServiceRESTUsers {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPA3PU";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {

        return Response
                .status(Response.Status.OK)
                .entity("{ \"mensaje\": \"Funciona correctamente\" }")
                .build();
    }

    @GET
    @Path("{dni}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("dni") Integer dni) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

        UsersJpaController dao = new UsersJpaController(emf);
        Users libro = dao.findUsers(dni);
        emf.close();
        Response response;
        response = Response
                .status(Response.Status.OK)
                .entity(libro)
                .build();
        return response;
    }
}
