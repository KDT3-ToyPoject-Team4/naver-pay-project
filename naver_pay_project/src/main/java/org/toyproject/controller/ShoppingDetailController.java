package org.toyproject.controller;

import org.apache.hc.core5.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.resource.HttpResource;
import org.toyproject.Service.ShoppingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShoppingDetailController {
    private ShoppingService shoppingService;
    @RequestMapping(value = "/shopping/ShoppingDetailList", method = RequestMethod.GET)
    public String ShoppingDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        shoppingService = new ShoppingService();
        shoppingService.execute(request,response);
        return "ShoppingDetail";
    }
}
