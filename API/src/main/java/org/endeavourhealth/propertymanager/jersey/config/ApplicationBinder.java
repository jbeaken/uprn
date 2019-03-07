package org.endeavourhealth.propertymanager.jersey.config;

import org.endeavourhealth.skeleton.api.dal.TemplateDAL_Hibernate;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(TemplateDAL_Hibernate.class).to(TemplateDAL_Hibernate.class);
    }
}
