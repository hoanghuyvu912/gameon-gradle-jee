package org.practice.security.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.practice.entity.Role;
import org.practice.entity.UserRoleAssignment;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private String email;

    @ApiModelProperty(example = "ROLE_USER")
    private List<String> roles;

    private String type = "Bearer";
    private boolean active;

    public JwtResponse(String token, String email, List<String> roles, boolean active) {
        this.token = token;
        this.email = email;
        this.roles = roles;
        this.active = active;
    }
}
