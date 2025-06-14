package WS;

import java.util.Set;
import jakarta.ws.rs.core.Application;

@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(WS.CorsFilter.class);
        resources.add(WS.GenericResource.class);
    }
}
