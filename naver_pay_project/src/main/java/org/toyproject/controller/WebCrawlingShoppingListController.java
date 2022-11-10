package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DTO.WebCrawlingShoppingListDTO;
import org.toyproject.entity.WebCrawlingShoppingListEntity;
import org.toyproject.service.WebCrawlingShoppingListService;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

@Controller
public class WebCrawlingShoppingListController {

    private String controllerUserId;
    private String controllerUserPassword;

    @RequestMapping("/crawling")
    public String loading(){
        return "CrawlingLogin";
    }

    @RequestMapping("/loading")
    public String crawlingLogin(@RequestParam String userId, String userPassword, Model model){
        controllerUserId=userId;
        controllerUserPassword=userPassword;
        return "Loading";
    }
    @RequestMapping("/crawlingResult")
    public String naverLogin(Model model) throws ParseException, AWTException {
        List<WebCrawlingShoppingListEntity> theEntityList = WebCrawlingShoppingListService.getShoppingListFromWeb(controllerUserId,controllerUserPassword);
        model.addAttribute("crawlingResult",theEntityList);
        return "CrawlingResult";
    }


}
