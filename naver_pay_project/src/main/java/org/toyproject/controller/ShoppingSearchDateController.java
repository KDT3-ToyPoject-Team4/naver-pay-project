package org.toyproject.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.Service.OrderedProductHistoryService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 수정 필요...
 */
@Controller
public class ShoppingSearchDateController {

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/getSearchDate")
    public String Shopping(
                            @RequestParam("startDate") Date startDate,
                           @RequestParam("endDate") Date endDate, Model model) throws ParseException {
        String userId="a1234";
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        System.out.println(startDate);
        System.out.println(endDate);
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        if(theService.orderedProductHistoryBetweenDate(userId,sqlStartDate,sqlEndDate).size()==0){
            return "NoOrderHistory";
        }
        model.addAttribute("dtoList",theService.orderedProductHistoryBetweenDate(userId,startDate,endDate));
        model.addAttribute("shoppingList",theService.orderedProductHistoryBetweenDate(userId,startDate,endDate).size() + "건의 검색결과");

        return "Shopping";

    }
}
