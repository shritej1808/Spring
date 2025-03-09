//package com.shritej.springsec.filter;
//
//import com.shritej.springsec.constants.ApplicationConstants;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.core.env.Environment;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.crypto.SecretKey;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
//
//    private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 30 minutes
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication != null) {
//            Environment environment = getEnvironment();
//            if (environment != null) {
//                String secret = environment.getProperty(ApplicationConstants.JWT_SECRET_KEY,
//                        ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
//                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//
//                String jwt = Jwts.builder()
//                        .issuer("Shritej Security")  // Change to your app name
//                        .subject(authentication.getName())
//                        .claim("username", authentication.getName())
//                        .claim("authorities", authentication.getAuthorities()
//                                .stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.joining(","))) // Use "," instead of "."
//                        .issuedAt(new Date())
//                        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                        .signWith(secretKey)
//                        .compact();
//
//                response.setHeader(ApplicationConstants.JWT_HEADER, jwt);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return !request.getServletPath().equals("/user");
//    }
//}
