package org.example.springboot.helloworldapp.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.springboot.helloworldapp.bean.AuthenticationBean;




//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/v1")
public class BasicAuthController {

    @GetMapping(path = "/")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("Hi vasanthamani,Welcome to IT world");
    }

    @GetMapping(path = "/users")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }


    @GetMapping("/admin")
    public String admin(){
        return  ("<h1>Welcome Admin</h1>");
    }
}