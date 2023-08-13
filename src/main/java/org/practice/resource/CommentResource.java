package org.practice.resource;

import org.practice.service.CommentService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("comments")
@Produces({MediaType.APPLICATION_JSON})
public class CommentResource {
    @Inject
    private CommentService commentService;

    @GET
    public Response getAll() {
        return Response.ok(commentService.getAll()).build();
    }
}
