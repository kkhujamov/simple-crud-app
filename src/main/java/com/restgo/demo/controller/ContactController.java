package com.restgo.demo.controller;

import com.restgo.demo.model.Contact;
import com.restgo.demo.model.Result;
import com.restgo.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService service;

    @GetMapping("/list")
    @ResponseBody
    public List<Contact> getContacts(){
        return service.getAllContact();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Contact getContactById(@PathVariable(value = "id") Integer id){
        return service.getContactById(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public Result saveContact(@Valid @ModelAttribute Contact contact, BindingResult result){
        return service.saveContact(contact,result);
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public Result editContact(@PathVariable Integer id, @Valid @ModelAttribute Contact contact,BindingResult bindingResult){
        return service.editContact(id,contact,bindingResult);
    }

    @DeleteMapping("/delete/{contactId}")
    @ResponseBody
    public Result deleteById( @PathVariable(value = "contactId") Integer id){
        return service.deleteById(id);
    }

}
