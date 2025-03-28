//package com.shritej.springsec.filter;
//
//import com.shritej.springsec.constants.ApplicationConstants;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.crypto.SecretKey;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//public class JWTTokenValidatorFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String jwt = request.getHeader(ApplicationConstants.JWT_HEADER);
//
//        if (jwt != null) {
//            try {
//                Environment environment = getEnvironment();
//                if (environment != null) {
//                    String secret = environment.getProperty(ApplicationConstants.JWT_SECRET_KEY,
//                            ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
//
//                    SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//
//                    Claims claims = Jwts.parser()
//                            .verifyWith(secretKey)
//                            .build()
//                            .parseSignedClaims(jwt)
//                            .getPayload();
//
//                    String username = claims.get("username", String.class);
//                    String authorities = claims.get("authorities", String.class);
//
//                    Authentication authentication = new UsernamePasswordAuthenticationToken(
//                            username,
//                            null,
//                            AuthorityUtils.commaSeparatedStringToAuthorityList(authorities) // FIXED: Correctly parsing authorities
//                    );
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (Exception e) {
//                throw new BadCredentialsException("Bad credentials");
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return request.getServletPath().equals("/user");
//    }
//}
