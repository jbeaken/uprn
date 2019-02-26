package org.endeavourhealth.skeleton.api.endpoints;
import com.codahale.metrics.annotation.Timed;

import org.endeavour.uprn.bean.Address;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/matcher")
@Api(description = "Api for all calls relating to the template")
public class PropertyMatcher {

    private static final Logger logger = LoggerFactory.getLogger(PropertyMatcher.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name="Template.TemplateEndpoint.Message.Get")
    @Path("/address")
    @ApiOperation(value = "Matches an address to a property")
    public Response get(@Context SecurityContext securityContext, Address address) {

        logger.info("Have received api request for address {}", address);
        logger.info("SecurityContext {}", securityContext);

        return Response
              .ok()
              .build();
    }
}
