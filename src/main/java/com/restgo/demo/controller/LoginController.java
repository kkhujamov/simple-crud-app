package com.restgo.demo.controller;

import com.restgo.demo.model.Result;
import com.restgo.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result authUser(@RequestParam(defaultValue = "username") String username,
                           @RequestParam(defaultValue = "password") String password){
        return service.authUser(username,password);
    }

}
