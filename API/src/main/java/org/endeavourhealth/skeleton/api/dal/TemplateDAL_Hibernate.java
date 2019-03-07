package org.endeavourhealth.skeleton.api.dal;


import org.endeavourhealth.propertymanager.model.DiscoveryAddress;

import org.endeavourhealth.skeleton.api.endpoints.PropertyMatcherEndpoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TemplateDAL_Hibernate implements TemplateDAL {

    private SessionFactory sessionFactory;

    private final Logger logger = LoggerFactory.getLogger(PropertyMatcherEndpoint.class);

    @PostConstruct
    public void init() {
        logger.info("In Hiberate Repository, booting sessionFactory");

        long start = System.currentTimeMillis();

        sessionFactory = buildSessionFactory();

        long end = System.currentTimeMillis();

        logger.info("Successfully bootstrapped sessionFactory in {} milliseconds", (end - start));

    }

    @Override
    public List<DiscoveryAddress> getAddresses() {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Query query = session.createQuery("select da from DiscoveryAddress da");

        query.setFirstResult(0);
        query.setMaxResults(10);

        return query.list();
    }

    private SessionFactory buildSessionFactory() {

        //Bootstrap services
        BootstrapServiceRegistryBuilder builder = new BootstrapServiceRegistryBuilder();

        BootstrapServiceRegistry bootstrapServiceRegistry = builder.build();

        //Standard services
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder(bootstrapServiceRegistry);

        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "hibernate.cfg.xml" )
                .applySetting("hibernate.connection.username", "root")
                .applySetting("hibernate.connection.password", "cyclops")
                .build();

        //Metadata
        MetadataSources sources = new MetadataSources( standardRegistry );

//		sources.addPackage( "org.jack.scratchpad.domain" );
        sources.addAnnotatedClass( DiscoveryAddress.class );

        Metadata metadata = sources.buildMetadata();

        //SessionFactory
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory;
    }
}
