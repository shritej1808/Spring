package com.shritej.springsec.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(null!=authentication) {
            model.addAttribute("username",authentication.getName());
            model.addAttribute("roles",authentication.getAuthorities());
        }
            return "dashboard.html";


    }
}
