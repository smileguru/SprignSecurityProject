package com.example.springsecurityprogect.controller;

import com.example.springsecurityprogect.security.PersonDetails;
import com.example.springsecurityprogect.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private final AdminService adminService;

    @Autowired
    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) auth.getPrincipal();
        System.out.println(personDetails.person());
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStuff();
        return "admin";
    }
}
