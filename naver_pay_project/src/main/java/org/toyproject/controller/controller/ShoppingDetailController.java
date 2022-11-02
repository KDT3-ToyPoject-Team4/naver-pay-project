package org.toyproject.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingDetailController {
    @RequestMapping(value = "/shopping/getShoppingDetailList", method = RequestMethod.GET)
    public String ShoppingDetail(){
        return "ShoppingDetail";
    }
}
