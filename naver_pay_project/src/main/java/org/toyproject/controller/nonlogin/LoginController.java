package org.toyproject.controller.nonlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(){
        return "Login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String SignUP(){
        return "SignUp";
    }
}
