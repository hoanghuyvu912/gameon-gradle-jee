package org.practice.resource;

import org.practice.exception.ResourceNotFoundException;
import org.practice.service.DeveloperService;
import org.practice.service.GameService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("games")
@Produces({MediaType.APPLICATION_JSON})
public class GameResource {
    @Inject
    private GameService gameService;

    @GET
    public Response getAll() {
        return Response.ok(gameService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) throws ResourceNotFoundException {
        return Response.ok(gameService.getById(id)).build();
    }

    @GET
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    @Path("/with-codes-sold")
    public Response getWithCodesSold() {
        return Response.ok(gameService.getWithCodesSold()).build();
    }

    @GET
    @Path("/with-codes-available")
    public Response getWithCodesAvailable() {
        return Response.ok(gameService.getWithCodesAvailable()).build();
    }
}
