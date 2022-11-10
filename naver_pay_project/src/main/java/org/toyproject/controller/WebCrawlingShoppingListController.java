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


    @RequestMapping("/crawling")
    public String loading(){
        return "CrawlingLogin";
    }

    @RequestMapping("/loading")
    public String crawlingLogin(){
        return "Loading";
    }
    @RequestMapping("/crawlingResult")
    public String naverLogin(@RequestParam String userId, String userPassword, Model model) throws ParseException, AWTException {
        model.addAttribute("userId",userId);
        model.addAttribute("userPassword",userPassword);
        List<WebCrawlingShoppingListEntity> theEntityList = WebCrawlingShoppingListService.getShoppingListFromWeb(userId,userPassword);
        model.addAttribute("crawlingResult",theEntityList);
        return "CrawlingResult";
    }
}
