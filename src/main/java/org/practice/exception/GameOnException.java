package org.practice.exception;

import lombok.Getter;

import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response;

@Getter
@ApplicationException
public class GameOnException extends Exception {

    private final transient ResponseBody responseBody;

    public GameOnException(String keyMessage, String message) {
        this.responseBody = new ResponseBody(Response.Status.NOT_FOUND, keyMessage, message);
    }
}
