//package com.shritej.springsec.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//@Profile("prod")
//@RequiredArgsConstructor
//public class EazyProdBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
//    private final EazyBankUserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username=authentication.getName();
//        String pwd=authentication.getCredentials().toString();
//        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
//        if (passwordEncoder.matches(pwd,userDetails.getPassword())){
//            return new UsernamePasswordAuthenticationToken(userDetails,pwd,userDetails.getAuthorities());
//        }
//        else{
//            throw new BadCredentialsException("Bad credentials");
//        }
//
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//}
