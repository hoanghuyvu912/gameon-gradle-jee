package org.practice.security.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.practice.entity.Role;

import java.security.Principal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserPrincipal implements Principal {
    private String email;
    private List<String> roles;
//    private List<Role> roles;

    @Override
    public String getName() {
        return email;
    }
}
