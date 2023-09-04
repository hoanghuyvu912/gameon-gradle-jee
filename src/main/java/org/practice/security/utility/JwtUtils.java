package org.practice.security.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.practice.config.AppConfigService;
import org.practice.entity.UserEntity;
import org.practice.entity.UserRoleAssignment;
import org.practice.exception.AuthorizationException;
import org.practice.exception.ErrorMessage;
import org.practice.exception.InputValidationException;
import org.practice.security.controller.model.JwtRequest;
import org.practice.security.service.AuthenticationService;
import org.practice.security.service.dto.JwtResponse;
import org.practice.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Stateless
public class JwtUtils {
    private static final String EMAIL = "EMAIL";
    private static final String ROLE = "ROLE";
    private static final String BEARER = "Bearer";
    private static final Validator validator =
            Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory()
                    .getValidator();

    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private UserService userService;

    public String generateToken(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        if (!authenticationService.checkAuthentication(jwtRequest)) {
            throw new InputValidationException(ErrorMessage.KEY_PASS_EMAIL_INVALID, ErrorMessage.PASS_EMAIL_INVALID);
        }
        String token;
        String secretKey = AppConfigService.getSecretKey();
        String issuer = AppConfigService.getIssuer();
        int liveTime = AppConfigService.getTimeToLive();
        List<UserRoleAssignment> role = userService.getEntityByEmail(jwtRequest.getEmail()).getRoles();

        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            token = JWT.create()
                    .withIssuer(issuer)
                    .withIssuedAt(new Date())
                    .withJWTId(UUID.randomUUID().toString())
                    .withClaim(EMAIL, jwtRequest.getEmail())
                    .withClaim(ROLE, String.valueOf(role))
                    .withExpiresAt(new Date(System.currentTimeMillis() + liveTime))
                    .sign(algorithm);
        } catch (JWTCreationException | IllegalArgumentException e) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
        return token;
    }

    public void validateJwtToken(String token) throws AuthorizationException {
        if (token == null) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
        try {
            String secretKey = AppConfigService.getSecretKey();
            String issuer = AppConfigService.getIssuer();
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer).build();
            verifier.verify(token.substring(BEARER.length()).trim());
        } catch (JWTVerificationException | IllegalArgumentException e) {
            throw new AuthorizationException(Response.Status.UNAUTHORIZED, ErrorMessage.KEY_UNAUTHORIZED_ACCESS, ErrorMessage.UNAUTHORIZED_ACCESS);
        }
    }

    public JwtResponse generateJwtResponse(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        verifyJwtRequest(jwtRequest);
        String email = jwtRequest.getEmail().trim();
        String token = generateToken(jwtRequest);
        UserEntity user = userService.getEntityByEmail(email);
        List<UserRoleAssignment> role = user.getRoles();
        boolean active = user.isActive();

        return new JwtResponse(token, email, role, active);
    }

//    public List<UserRoleAssignment> getRoleFromToken(String authorization) {
//        String token = authorization.substring(BEARER.length()).trim();
//        DecodedJWT decodedJWT = JWT.decode(token);
//        return UserRoleAssignment.valueOf(decodedJWT.getClaim(ROLE).asString());
//    }

    public String getEmailFromToken(String authorization) {
        String token = authorization.substring(BEARER.length()).trim();
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim(EMAIL).asString();
    }

    public Date getExpireTokenTime(String authorization) {
        String token = authorization.substring(BEARER.length()).trim();
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getExpiresAt();
    }

    private boolean isActive(boolean active) {
        return active;
    }

    public void verifyJwtRequest(JwtRequest jwtRequest) throws AuthorizationException, InputValidationException {
        Set<ConstraintViolation<JwtRequest>> violations = validator.validate(jwtRequest);

        if (CollectionUtils.isNotEmpty(violations)) {
            throw new ConstraintViolationException(violations);
        }

        boolean active = userService.getEntityByEmail(jwtRequest.getEmail()).isActive();
        if (!isActive(active)) {
            throw new AuthorizationException(Response.Status.FORBIDDEN, ErrorMessage.KEY_FORBIDDEN_ACCESS, ErrorMessage.FORBIDDEN_ACCESS);
        }
    }
}
