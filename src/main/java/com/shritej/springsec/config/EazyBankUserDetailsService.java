//package com.shritej.springsec.config;
//
//import com.shritej.springsec.model.Customer;
//import com.shritej.springsec.repository.CustomerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class EazyBankUserDetailsService implements UserDetailsService {
//
//    private final CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = customerRepository.findByEmail(username).orElseThrow(() ->
//                new UsernameNotFoundException("User not found" + username));
//        List<GrantedAuthority> authorities=customer.getAuthorities()
//                .stream().map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                .collect(Collectors.toList());
////        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getAuthorities()));
//        return new User(customer.getEmail(), customer.getPwd(), authorities);
//    }
//}