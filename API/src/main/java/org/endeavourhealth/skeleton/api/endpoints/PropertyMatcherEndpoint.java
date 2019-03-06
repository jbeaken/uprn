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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Path("/matcher")
@Api(description = "Api for all calls to property matching service")
public class PropertyMatcherEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(PropertyMatcherEndpoint.class);

    private Client client = ClientBuilder.newClient();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name="Template.TemplateEndpoint.Message.Get")
    @Path("/match")
    @ApiOperation(value = "Matches an address to a property")
    public Response match(@Context SecurityContext securityContext, @QueryParam("line1") String line1, @QueryParam("line2") String line2, @QueryParam("line3") String line3) throws UnsupportedEncodingException {

        Address address = Address.builder()
                .addressLine1(line1)
                .addressLine2(line2)
                .addressLine3(line3)
                .postCode("E2 6HL")
                .build();

        logger.info("Have received api request for q {}", address.getAddressLine1());

        String q = URLEncoder.encode(address.getAddressLine1(), "UTF-8");

        Object object = client
                .target("http://localhost:9001/addresses?verbose=true&matchthreshold=5&rangekm=&historical=true&offset=0&classificationfilter=&lon=-3.5091076&enddate=&limit=10&input=" + q+ "&lat=50.705948&startdate=")
//                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Object.class);

        logger.info("Have response {}", object.toString());

        MatcherFactory factory = MatcherFactory.build();
//
        Result result = factory.match( address );

        logger.info("Result from address {} , {}", result, address);

        return Response
              .ok(object )
              .build();
    }
}
