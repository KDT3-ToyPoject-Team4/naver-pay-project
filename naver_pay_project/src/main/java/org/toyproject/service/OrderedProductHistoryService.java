package org.toyproject.service;

import org.toyproject.DAO.OrderedProductHistoryDAO;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.entity.OrderedProductHistoryEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderedProductHistoryService {

    private static OrderedProductHistoryService orderedProductHistoryService = null;


    public OrderedProductHistoryService(){}

    public static OrderedProductHistoryService getInstance(){
        if (orderedProductHistoryService ==null){
            orderedProductHistoryService =new OrderedProductHistoryService();
        }
        return orderedProductHistoryService;
    }

    public List<OrderedProductHistoryDTO> orderedProductHistoryBetweenDate (String userId, Date startDate, Date endDate) {
        OrderedProductHistoryDAO theDAO = OrderedProductHistoryDAO.getInstance();
        List<OrderedProductHistoryDTO> OrderedProductHistoryDTOs = new ArrayList<>();
        List<OrderedProductHistoryEntity> theEntities=theDAO.getOrderedProductHistoryEntityWithUserId(userId);
        if (theEntities != null) {
            for (OrderedProductHistoryEntity entity : theEntities) {
                if (entity.getOrderDate().compareTo(startDate)>0 && entity.getOrderDate().compareTo(endDate)<0){
                    OrderedProductHistoryDTO theDTO = new OrderedProductHistoryDTO();

                    /*User_info*/
                    theDTO.setUserId(entity.getUserId());
                    theDTO.setUserName(entity.getUserName());
                    theDTO.setUserPoint(entity.getUserPoint());
                    /*Product*/
                    theDTO.setProductName(entity.getProductName());
                    theDTO.setProductPrice(entity.getProductPrice());
                    /*Company*/
                    theDTO.setCompanyName(entity.getCompanyName());
                    theDTO.setCompany_tel(entity.getCompany_tel());
                    /*Order_info*/
                    theDTO.setOrderId(entity.getOrderId());
                    theDTO.setOrderDate(entity.getOrderDate());
                    OrderedProductHistoryDTOs.add(theDTO);
                }
            }
            return OrderedProductHistoryDTOs;
        }
        return null;
    }

    /*Entity를 DTO에 그대로 넣는다. (추가로 작업할게 없다)*/
    public List<OrderedProductHistoryDTO> orderedProductHistory (String userId){
        OrderedProductHistoryDAO theDAO = OrderedProductHistoryDAO.getInstance();
        List<OrderedProductHistoryDTO> OrderedProductHistoryDTOs = new ArrayList<>();
        List<OrderedProductHistoryEntity> theEntities=theDAO.getOrderedProductHistoryEntityWithUserId(userId);
        if(theEntities!=null){
            for (OrderedProductHistoryEntity dao : theEntities){
                OrderedProductHistoryDTO theDTO = new OrderedProductHistoryDTO();
                /*User_info*/
                theDTO.setUserId(dao.getUserId());
                theDTO.setUserPoint(dao.getUserPoint());
                /*Product*/
                theDTO.setProductName(dao.getProductName());
                theDTO.setProductPrice(dao.getProductPrice());
                /*Company*/
                theDTO.setCompanyName(dao.getCompanyName());
                theDTO.setCompany_tel(dao.getCompany_tel());
                /*Order_info*/
                theDTO.setOrderId(dao.getOrderId());
                theDTO.setOrderDate(dao.getOrderDate());

                OrderedProductHistoryDTOs.add(theDTO);

            }
            return OrderedProductHistoryDTOs;
        }
        return null;
    }
}
