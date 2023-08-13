package org.practice.resource;

import org.practice.service.GameImageService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("game-images")
@Produces({MediaType.APPLICATION_JSON})
public class GameImageResource {
    @Inject
    private GameImageService gameImageService;
    @GET
    public Response getAll() {
        return Response.ok(gameImageService.getAll()).build();
    }
}
