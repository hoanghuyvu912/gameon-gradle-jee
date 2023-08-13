package org.practice.resource;

import org.practice.service.GenreService;
import org.practice.service.SubGenreService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sub-genres")
@Produces({MediaType.APPLICATION_JSON})
public class SubGenreResource {
    @Inject
    private SubGenreService subGenreService;

    @GET
    public Response getAll() {
        return Response.ok(subGenreService.getAll()).build();
    }
}
