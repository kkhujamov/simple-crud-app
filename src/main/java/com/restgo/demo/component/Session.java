package com.restgo.demo.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

@Component
@SessionScope
@Data
public class Session {
    @Autowired
    HttpServletRequest request;
    private Integer userId;

    public Session get(HttpServletRequest request){
        return (Session) WebUtils.getSessionAttribute(request,"ENV");
    }

    public void set(){
        WebUtils.setSessionAttribute(request,"ENV",this);
    }

    public void remove(){
        request.getSession().invalidate();
    }

}
