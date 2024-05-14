/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package sersimplefit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import jpasimplefit.Usuarios;
import jpasimplefit.UsuariosJpaController;

@Path("usuarios")
public class ServiceRESTUsuarios {

    private static final String PERSISTENCE_UNIT = "SimpleFitApiJPA1.1PU";
    @Context
    private UriInfo context;
    public ServiceRESTUsuarios(){}
    
    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("email") String email) {
        EntityManagerFactory emf = null;
        
        
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        Usuarios usu;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            //UsuariosJpaController dao = new UsuariosJpaController(emf);
            //usu = dao.findUsuarios(email);
            EntityManager em = emf.createEntityManager();
            
            
            TypedQuery<Usuarios> query = em.createQuery(
            "SELECT u FROM Usuarios u WHERE u.email = :email", Usuarios.class);
            query.setParameter("email", email);
            usu = query.getSingleResult();//Tampoco funciona
            

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
        Status statusResul;
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

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response
                .status(Response.Status.OK)
                .entity("{ \"mensaje\": \"Funciona correctamente\" }")
                .build();
    }
     */
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
