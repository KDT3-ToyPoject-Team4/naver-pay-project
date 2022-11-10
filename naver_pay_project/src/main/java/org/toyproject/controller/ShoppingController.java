package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.service.OrderedProductHistoryService;

import java.text.ParseException;

@Controller
public class ShoppingController {
    @RequestMapping(value = "/shoppingList")
    public String Shopping(@RequestParam("Id") String userId, Model model) throws ParseException {
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        if (theService==null){
            return "NoOrderHistory";
        }
        model.addAttribute("DtoList",theService.orderedProductHistory(userId));
        return "Shopping";
    }
}
