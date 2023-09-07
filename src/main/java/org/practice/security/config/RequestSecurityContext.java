package org.practice.security.config;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class RequestSecurityContext implements SecurityContext {

    private final UserPrincipal userPrincipal;

    public RequestSecurityContext(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    @Override
    public Principal getUserPrincipal() {
        return userPrincipal;
    }

    @Override
    public boolean isUserInRole(String s) {
//        return userPrincipal.getRoles().name().equals(s);
        return userPrincipal.getRoles().contains(s);
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
