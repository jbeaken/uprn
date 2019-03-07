package org.endeavourhealth.propertymanager.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(new ApplicationBinder());
    }
}
