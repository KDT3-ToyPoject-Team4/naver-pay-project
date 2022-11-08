package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.toyproject.Service.OrderedProductHistoryService;

import java.text.ParseException;

@Controller
public class ShoppingController {
    @RequestMapping(value = "/shopping/getShoppingList")
    public String Shopping(@ModelAttribute String userId, Model model) throws ParseException {
        OrderedProductHistoryService orderService = OrderedProductHistoryService.getInstance();
        model.addAttribute("DtoList",orderService.orderedProductHistory(userId));
        return "Shopping";
    }
}
