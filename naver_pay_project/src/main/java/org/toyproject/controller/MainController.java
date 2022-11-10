package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.toyproject.Service.UserService;

@Controller
public class MainController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String MainPage(){
        return "index";
    }
}
