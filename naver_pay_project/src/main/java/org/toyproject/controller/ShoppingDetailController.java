package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.ShoppingDetailDTO;
import org.toyproject.service.ShoppingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShoppingDetailController {
    public ShoppingService shoppingService;
    @RequestMapping(value = "shopping/getShoppingDetailList/{orderId}", method = RequestMethod.GET)
    public String ShoppingDetail(Model model,@PathVariable("orderId") String orderId) throws Exception {
        shoppingService = new ShoppingService();
        Long orderID = Long.parseLong(orderId);
        System.out.println(orderId);
        ShoppingDetailDTO shoppingDetailDTO = shoppingService.showShoppingDetail(orderID);

        model.addAttribute("order",shoppingDetailDTO);
        return "ShoppingDetail";
    }
}
