package org.endeavourhealth.skeleton.api.endpoints;
import com.codahale.metrics.annotation.Timed;

import org.endeavour.uprn.bean.Address;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.factory.MatcherFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/matcher")
@Api(description = "Api for all calls to property matching service")
public class PropertyMatcherEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(PropertyMatcherEndpoint.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name="Template.TemplateEndpoint.Message.Get")
    @Path("/address")
    @ApiOperation(value = "Matches an address to a property")
    public Response et(@Context SecurityContext securityContext, @QueryParam("line1") String line1, @QueryParam("line2") String line2, @QueryParam("line3") String line3) {

        Address address = Address.builder()
                .addressLine1(line1)
                .addressLine2(line2)
                .addressLine3(line3)
                .postCode("E2 6HL")
                .build();

        logger.info("Have received api request for address {}", address);
        logger.info("SecurityContext {}", securityContext);

        MatcherFactory factory = MatcherFactory.build();

        Result result = factory.match( address );

        logger.info("Testing testing");
        logger.info("Result from address {} , {}", result, address);
        logger.info("Testing redeploy");

        return Response
              .ok(result)
              .build();
    }
}
