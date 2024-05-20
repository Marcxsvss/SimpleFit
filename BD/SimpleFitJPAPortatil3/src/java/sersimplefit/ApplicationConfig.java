package sersimplefit;

import java.util.Set;

/**
 *
 * @author marki
 */
@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends jakarta.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sersimplefit.ServiceRESTUsuarios.class);
        resources.add(sersimplefit.ServiceRESTRutinas.class);
        resources.add(sersimplefit.ServiceRESTMaquinas.class);
        resources.add(sersimplefit.ServiceRESTRutinamaquina.class);
        resources.add(sersimplefit.ServiceRESTConsejos.class);
    }
    
}
