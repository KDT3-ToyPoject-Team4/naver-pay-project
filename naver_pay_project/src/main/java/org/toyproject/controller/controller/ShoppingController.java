package org.toyproject.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingController {
    @RequestMapping(value = "/shopping/getShoppingList", method = RequestMethod.GET)
    public String Shopping(Model model){
        model.addAttribute("shoppingList","날짜 입력 전 화면입니다.");
        return "Shopping";
    }
}
