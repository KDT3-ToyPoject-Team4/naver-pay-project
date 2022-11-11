package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.service.OrderedProductHistoryService;
import org.toyproject.service.SessionMgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class ShoppingController {

    @RequestMapping(value = "shopping/getShoppingList")
    public String Shopping(HttpSession session, Model model) throws ParseException {
        SessionMgr sessionMgr=SessionMgr.getInstance();
        String userId = sessionMgr.get(session, "SESSION_ID");

        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        System.out.println("_________________");
        System.out.println();
        if (theService==null){
            return "NoOrderHistory";
        }
        model.addAttribute("DtoList",theService.orderedProductHistory(userId));
        return "Shopping";
    }
}
