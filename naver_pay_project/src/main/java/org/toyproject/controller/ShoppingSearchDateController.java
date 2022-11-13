package org.toyproject.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.service.OrderedProductHistoryService;
import org.toyproject.service.SessionMgr;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @RequestMapping(value = "shopping/getSearchDate")
    public String Shopping(HttpSession session,
                           @RequestParam("startDate") Date startDate,
                           @RequestParam("endDate") Date endDate, Model model) throws ParseException {
        SessionMgr sessionMgr=SessionMgr.getInstance();
        String userId = sessionMgr.get(session, "SESSION_ID");
//        System.out.println(userId);
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        OrderedProductHistoryService theService = OrderedProductHistoryService.getInstance();
        List<OrderedProductHistoryDTO> theDTOs = theService.orderedProductHistoryBetweenDate(userId,sqlStartDate,sqlEndDate);
        if(theDTOs.size()==0){
            return "NoOrderHistory";
        }
        model.addAttribute("DtoList",theDTOs);
        model.addAttribute("shoppingList",theDTOs.size() + "건의 검색결과");
        return "Shopping";

    }
}
