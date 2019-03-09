package org.endeavourhealth.propertymanager.test.integration;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.endeavourhealth.skeleton.api.dal.TemplateDAL_Hibernate;
import org.endeavourhealth.skeleton.api.endpoints.PropertyMatcherEndpoint;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import org.junit.Test;

public class MatcherIntegrationTest extends JerseyTest {


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

        WebTarget webTarget = target("/matcher/match");

        webTarget = webTarget.queryParam("line1", "asdf");
        webTarget = webTarget.queryParam("line2", "asdf");

        Response response = webTarget.request().get();

        assertEquals("Http Response should be 200: ",
                Status.OK.getStatusCode(),
                response.getStatus());

        assertEquals("Http Content-Type should be: ",
                MediaType.APPLICATION_JSON,
                response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        String content = response.readEntity(String.class);

    }
}