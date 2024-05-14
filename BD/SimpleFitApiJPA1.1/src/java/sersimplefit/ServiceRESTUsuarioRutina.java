/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Usuarios;
import jpasimplefit.UsuariosJpaController;

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

    
    
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
