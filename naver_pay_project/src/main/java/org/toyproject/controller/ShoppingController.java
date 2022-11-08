package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.Service.OrderedProductHistoryService;

import java.text.ParseException;

@Controller
public class ShoppingController {
    @RequestMapping(value = "/shopping/getShoppingList")
    public String Shopping(@RequestParam String userId, Model model) throws ParseException {
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        model.addAttribute("DtoList",theService.orderedProductHistory(userId));
        return "Shopping";
    }
}
