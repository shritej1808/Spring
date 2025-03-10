package com.shritej.springsec.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakOpaqueRoleConvertor implements
        OpaqueTokenAuthenticationConverter {

    @Override
    public Authentication convert(String introspectedToken, OAuth2AuthenticatedPrincipal authenticatedPrincipal) {
        String username=authenticatedPrincipal.getAttribute("preferred_username");
        Map<String ,Object> realmaccess=authenticatedPrincipal.getAttribute("realm_access");
        Collection<GrantedAuthority> roles= ((List<String>) realmaccess.get("roles"))
                .stream()
                .map(rolename->"ROLE_"+rolename)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(authenticatedPrincipal.getName(),null,roles);
    }
}
