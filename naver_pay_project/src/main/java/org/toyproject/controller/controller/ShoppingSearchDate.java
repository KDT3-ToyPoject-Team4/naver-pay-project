package org.toyproject.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingSearchDate {
    @RequestMapping(value = "/shopping/getSearchDate", method = RequestMethod.GET)
    public String SearchDate(Model model){
        model.addAttribute("shoppingList","날짜 검색후 변경된 리스트 입니다.");
        return "Shopping";
    }
}
