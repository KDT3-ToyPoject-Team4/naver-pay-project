package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.toyproject.DTO.ShoppingDetailDTO;
import org.toyproject.service.ShoppingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShoppingDetailController {
    private ShoppingService shoppingService = new ShoppingService();
    @RequestMapping(value = "shopping/getShoppingDetailList/{orderId}", method = RequestMethod.GET)
    public String ShoppingDetail(Model model, @PathVariable("orderId") String orderId){
        Long orderID = Long.parseLong(orderId);
        ShoppingDetailDTO shoppingDetailDTO = shoppingService.showShoppingDetail(orderID);
        System.out.println(shoppingDetailDTO.toString());
        if(shoppingDetailDTO != null){
            model.addAttribute("order",shoppingDetailDTO);
        }

        return "ShoppingDetail";
    }
}
