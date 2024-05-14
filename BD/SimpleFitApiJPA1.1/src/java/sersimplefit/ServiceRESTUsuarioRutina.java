/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Marcos
 */
@Path("usuariorutina")
public class ServiceRESTUsuarioRutina {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTUsuarioRutina
     */
    public ServiceRESTUsuarioRutina() {
    }

    /**
     * Retrieves representation of an instance of sersimplefit.ServiceRESTUsuarioRutina
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceRESTUsuarioRutina
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
