package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.toyproject.DTO.WebCrawlingShoppingListDTO;
import org.toyproject.Entity.WebCrawlingShoppingListEntity;
import org.toyproject.Service.WebCrawlingShoppingListService;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

@Controller
public class WebCrawlingShoppingListController {


    @RequestMapping("/crawling/getShoppingList")
    public String naverLogin(@ModelAttribute WebCrawlingShoppingListDTO dto, Model model) throws ParseException, AWTException {
        List<WebCrawlingShoppingListEntity> theList = WebCrawlingShoppingListService.getShoppingListFromWeb(dto.getUserId(),dto.getUserPassword());
        dto.setEntitiesList(theList);
        model.addAttribute("dto",dto);
        return "CrawlingResult";
    }
}
