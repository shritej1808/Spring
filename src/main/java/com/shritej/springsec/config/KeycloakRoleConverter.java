package com.shritej.springsec.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        // Extract realm_access claim
        Map<String, Object> realmAccess = source.getClaim("realm_access");

        // Validate that realmAccess is not null and contains "roles"
        if (realmAccess == null || !realmAccess.containsKey("roles")) {
            return new ArrayList<>();
        }

        // Extract roles and convert them to GrantedAuthority
        Object rolesObject = realmAccess.get("roles");
        if (!(rolesObject instanceof List<?> rolesList)) {
            return new ArrayList<>();
        }

        return rolesList.stream()
                .filter(role -> role instanceof String)  // Ensure role is a string
                .map(role -> "ROLE_" + role)            // Prefix with ROLE_
                .map(SimpleGrantedAuthority::new)       // Convert to GrantedAuthority
                .collect(Collectors.toList());
    }
}
