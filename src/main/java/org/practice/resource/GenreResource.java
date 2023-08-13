package org.practice.resource;

import org.practice.service.GenreService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("genres")
@Produces({MediaType.APPLICATION_JSON})
public class GenreResource {
    @Inject
    private GenreService genreService;

    @GET
    public Response getAll() {
        return Response.ok(genreService.getAll()).build();
    }
}
