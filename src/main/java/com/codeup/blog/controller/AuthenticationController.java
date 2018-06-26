package com.codeup.blog.controller;

import com.codeup.blog.SecurityConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {


    @GetMapping("/login")
    public String showLoginForm() {

        return "/users/login";
    }

}
