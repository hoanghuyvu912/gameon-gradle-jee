package org.practice.resource;

import org.practice.service.PublisherService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("publishers")
@Produces({MediaType.APPLICATION_JSON})
public class PublisherResource {
    @Inject
    private PublisherService publisherService;

    @GET
    public Response getAll() {
        return Response.ok(publisherService.getAll()).build();
    }
}
