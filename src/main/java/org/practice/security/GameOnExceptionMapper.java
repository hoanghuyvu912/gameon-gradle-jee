package org.practice.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GameOnExceptionMapper implements ExceptionMapper<GameOnException> {
    private static final Logger logger = LogManager.getLogger(GameOnExceptionMapper.class);

    @Override
    public Response toResponse(GameOnException e) {
        StackTraceElement[] stackTraceArray = e.getStackTrace();
        for (StackTraceElement s : stackTraceArray) {
            logger.error(s.getClassName());
        }
        ResponseBody responseBody = e.getResponseBody();

        return Response.status(responseBody.getStatusCode())
                .entity(responseBody)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
