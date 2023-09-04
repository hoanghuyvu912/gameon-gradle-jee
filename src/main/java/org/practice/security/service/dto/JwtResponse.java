package org.practice.security.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
    private List<UserRoleAssignment> role;

    private String type = "Bearer";
    private boolean active;

    public JwtResponse(String token, String email, List<UserRoleAssignment> role, boolean active) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.active = active;
    }
}
