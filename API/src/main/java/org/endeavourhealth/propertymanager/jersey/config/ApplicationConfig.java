package org.endeavourhealth.propertymanager.jersey.config;

import org.endeavourhealth.skeleton.api.dal.TemplateDAL_Hibernate;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(new ApplicationBinder());
        register(new TemplateDAL_Hibernate());
    }
}
