package sersimplefit;

import java.util.Set;

@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends jakarta.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sersimplefit.ServiceRESTUsuarios.class);
        resources.add(sersimplefit.ServiceRESTRutinas.class);
        resources.add(sersimplefit.ServiceRESTMaquinas.class);
        resources.add(sersimplefit.ServiceRESTRutinamaquina.class);
        resources.add(sersimplefit.ServiceRESTConsejos.class);
    }
    
}
