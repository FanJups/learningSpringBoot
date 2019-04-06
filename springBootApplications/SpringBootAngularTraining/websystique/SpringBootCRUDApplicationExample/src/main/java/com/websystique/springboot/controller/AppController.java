package com.websystique.springboot.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class AppController {
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model) {
        model.addAttribute("title","CRUD Example"); 
        return "index";
    }
 
    @RequestMapping(value = "/partials/{page}", method = RequestMethod.GET)
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
 
}