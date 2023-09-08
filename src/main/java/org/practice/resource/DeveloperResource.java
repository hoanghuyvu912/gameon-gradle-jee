package org.practice.resource;

import org.practice.service.DeveloperService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("developers")
@Produces({MediaType.APPLICATION_JSON})
public class DeveloperResource {
    @Inject
    private DeveloperService developerService;


    @GET
    public Response getAll() {
        return Response.ok(developerService.getAll()).build();
    }


}
