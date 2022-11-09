package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.Service.OrderedProductHistoryService;

import java.text.ParseException;
import java.util.List;

@Controller
public class ShoppingController {
    @RequestMapping(value = "/shoppingList")
    public String Shopping(@RequestParam("Id") String userId, Model model) throws ParseException {
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        List<OrderedProductHistoryDTO> result=theService.orderedProductHistory(userId);
        model.addAttribute("dtoList",theService.orderedProductHistory(userId));
        return "Shopping";
    }
}
