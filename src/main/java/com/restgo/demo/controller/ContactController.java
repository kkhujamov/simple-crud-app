package com.restgo.demo.controller;

import com.restgo.demo.model.Contact;
import com.restgo.demo.model.Result;
import com.restgo.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService service;

    // get Home Page at http://localhost:8080/contact
    @GetMapping()
    public String getHomePage(){
        return "index";
    }

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
    public Result saveContact(@ModelAttribute Contact contact){
        return service.saveContact(contact);
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public Result editContact(@PathVariable Integer id, @ModelAttribute Contact contact){
        return service.editContact(id,contact);
    }

    @DeleteMapping("/delete/{contactId}")
    @ResponseBody
    public Result deleteById( @PathVariable(value = "contactId") Integer id){
        return service.deleteById(id);
    }


}
