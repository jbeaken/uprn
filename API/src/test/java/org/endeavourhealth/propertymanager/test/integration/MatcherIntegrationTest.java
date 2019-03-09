package org.endeavourhealth.propertymanager.test.integration;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.endeavour.uprn.factory.MatcherFactory;
import org.endeavourhealth.skeleton.api.dal.TemplateDAL_Hibernate;
import org.endeavourhealth.skeleton.api.endpoints.PropertyMatcherEndpoint;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatcherIntegrationTest extends JerseyTest {

    private final Logger logger = LoggerFactory.getLogger(MatcherIntegrationTest.class);

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        ResourceConfig config = new ResourceConfig(PropertyMatcherEndpoint.class);

        config.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(TemplateDAL_Hibernate.class).to(TemplateDAL_Hibernate.class);
            }
        });

        return config;
    }

    @Test
    public void givenGetMatch_whenCorrectRequest_thenResponseIsOkAndContainsHi() {

        Response response = target("/matcher/match")
                .queryParam("line1", "asdf")
                .queryParam("line2", "asdf")
                .request()
                .get();

        assertThat( response.getStatus() ).isEqualTo(  Status.OK.getStatusCode() );

        assertThat( response.getHeaderString(HttpHeaders.CONTENT_TYPE) ).isEqualTo(  MediaType.APPLICATION_JSON );

        String content = response.readEntity(String.class);

        logger.warn(content);

    }
}