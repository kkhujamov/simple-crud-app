package com.restgo.demo.service;

import com.restgo.demo.component.Session;
import com.restgo.demo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    Session session;

    public Result authUser(String username,String password){
        Result result = new Result();
        if (username.equals("user") && password.equals("user")){
            result.setSuccess(true);
            result.setMessage("User authenticated");
            session.setUserId(1);
            session.set();
        }else {
            result.setSuccess(false);
            result.setMessage("User Not authenticated");
        }
        return result;
    }
}
