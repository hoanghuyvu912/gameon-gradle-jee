package org.practice.security.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.practice.entity.Role;
import org.practice.exception.AuthorizationException;
import org.practice.exception.ErrorMessage;
import org.practice.exception.ResponseBody;
import org.practice.security.utility.JwtUtils;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.UUID;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(AuthorizationFilter.class);

    @Context
    private ResourceInfo info;

    @Inject
    private JwtUtils jwtUtils;

    @Override
    public void filter(ContainerRequestContext request) {
        //@DenyAll in class or method: Abort Always
        if (isDenied()) {
            request.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity(new ResponseBody(Response.Status.FORBIDDEN, ErrorMessage.KEY_FORBIDDEN_ACCESS, ErrorMessage.FORBIDDEN_ACCESS))
                    .build());
            return;
        }

        RolesAllowed methodRoles = info.getResourceMethod().getAnnotation(RolesAllowed.class);
        RolesAllowed classRoles = info.getResourceClass().getAnnotation(RolesAllowed.class);

        if (methodRoles == null && classRoles == null) {
            return;
        }

        String authHeader = request.getHeaderString("Authorization");
        if (isNotValidJwt(authHeader)) {
            logger.info("Unauthorized access");
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new ResponseBody(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS)).build());
            return;
        }


//        List<Role> roles = jwtUtils.getRoleFromToken(authHeader);
        List<String> roles = jwtUtils.getRoleFromToken(authHeader);
        String email = jwtUtils.getEmailFromToken(authHeader);
        SecurityContext sc = new RequestSecurityContext(new UserPrincipal(email, roles));

        String[] localPart = email.split("@");
        ThreadContext.put("mail", localPart[0] + ":" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));

        request.setSecurityContext(sc);

        //Forbidden when class-level OR method-level roles do not match
        if (hasNoRole(classRoles, request.getSecurityContext())
                || hasNoRole(methodRoles, request.getSecurityContext())) {
            logger.info("Forbidden access");
            request.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity(new ResponseBody(Response.Status.FORBIDDEN, ErrorMessage.KEY_FORBIDDEN_ACCESS, ErrorMessage.FORBIDDEN_ACCESS)).build());
        }
    }

    private boolean isDenied() {
        DenyAll methodDenyAll = info.getResourceMethod().getAnnotation(DenyAll.class);
        DenyAll classDenyAll = info.getResourceClass().getAnnotation(DenyAll.class);
        return methodDenyAll != null || classDenyAll != null;
    }

    private boolean isNotValidJwt(String header) {
        if (header == null) {
            return true;
        }

        try {
            jwtUtils.validateJwtToken(header);
        } catch (AuthorizationException e) {
            return true;
        }

        return !header.startsWith("Bearer ");
    }

    private boolean hasNoRole(RolesAllowed anno, SecurityContext sc) {
        if (anno == null) {
            return false;
        }

        String[] roleStrings = anno.value();
        for (String roleString : roleStrings) {
            if (sc.isUserInRole(roleString)) {
                return false;
            }
        }
        return true;
    }
}
