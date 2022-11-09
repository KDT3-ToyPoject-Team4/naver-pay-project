package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.Service.OrderedProductHistoryService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 수정 필요...
 */
@Controller
public class ShoppingSearchDateController {
    @RequestMapping(value = "/shopping/getSearchDate", method = RequestMethod.GET)
    public String SearchDate(Model model){
        model.addAttribute("shoppingList","날짜 검색후 변경된 리스트 입니다.");
        return "Shopping";
    }
    @RequestMapping(value = "/shoppingList/getSearchDate")
    public String Shopping(@RequestParam("Id") String userId,
                           @RequestParam("startDate") Date startDate,
                           @RequestParam("endDate") Date endDate, Model model) throws ParseException {
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        List<OrderedProductHistoryDTO> result=theService.orderedProductHistory(userId);
        model.addAttribute("dtoList",theService.orderedProductHistory(userId));
        return "Shopping";
    }
}
