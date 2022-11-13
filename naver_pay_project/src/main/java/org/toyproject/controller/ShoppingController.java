package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.DTO.UserDTO;
import org.toyproject.service.OrderedProductHistoryService;
import org.toyproject.service.SessionMgr;
import org.toyproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ShoppingController {

    private static UserService userService = new UserService();

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
        List<OrderedProductHistoryDTO> orderList = theService.orderedProductHistory(userId);
        if(!userId.equals("") && orderList.size() == 0){
            orderList = new LinkedList<>();
            OrderedProductHistoryDTO orderDTO = new OrderedProductHistoryDTO();
            UserDTO userDTO = userService.showUserInfo(userId);
            orderDTO.setUserId(userId);
            orderDTO.setUserName(userDTO.getUserName());
            orderDTO.setUserPoint(userDTO.getUserPoint());
            orderDTO.setOrderId(null);
            orderList.add(orderDTO);
        }
        model.addAttribute("DtoList",orderList);
        return "Shopping";
    }
}
