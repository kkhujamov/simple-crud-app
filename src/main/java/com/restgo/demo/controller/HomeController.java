package com.restgo.demo.controller;

import com.restgo.demo.component.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    Session session;

    // get Home Page at http://localhost:8080/index
    @GetMapping("/index")
    public String getHomePage(){
        return "index";
    }

    @PostMapping("/logout")
    @ResponseBody
    public void logout(){
        session.remove();
    }
}
