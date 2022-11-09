package org.toyproject.Service;

import org.toyproject.DAO.OrderedProductHistoryDAO;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.Entity.OrderedProductHistoryEntity;

import java.text.SimpleDateFormat;
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

    public static boolean compareDate(Date theDate, Date startDate, Date endDate){
        if (theDate.compareTo(startDate) > 0 && (theDate.compareTo(endDate))< 0){
            return true;
        }
        return false;
    }


    /*Entity를 DTO에 그대로 넣는다. (추가로 작업할게 없다)*/
    public List<OrderedProductHistoryDTO> orderedProductHistoryBetweenDate (String userId, Date startDate, Date endDate) {
        OrderedProductHistoryDAO theDAO = OrderedProductHistoryDAO.getInstance();
        List<OrderedProductHistoryDTO> OrderedProductHistoryDTOs = new ArrayList<>();

        List<OrderedProductHistoryEntity> a = theDAO.getOrderedProductHistoryEntityWithUserId(userId);

        if (theDAO.getOrderedProductHistoryEntityWithUserId(userId) != null) {
            for (OrderedProductHistoryEntity dao : theDAO.getOrderedProductHistoryEntityWithUserId(userId)) {
                if (compareDate(dao.getOrderDate(), startDate, endDate)) {
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
            }
            return OrderedProductHistoryDTOs;
        }
        return null;
    }

    public List<OrderedProductHistoryDTO> orderedProductHistory (String userId){
        OrderedProductHistoryDAO theDAO = OrderedProductHistoryDAO.getInstance();
        List<OrderedProductHistoryDTO> OrderedProductHistoryDTOs = new ArrayList<>();

        List<OrderedProductHistoryEntity> a = theDAO.getOrderedProductHistoryEntityWithUserId(userId);

        if(theDAO.getOrderedProductHistoryEntityWithUserId(userId)!=null){
            for (OrderedProductHistoryEntity dao : theDAO.getOrderedProductHistoryEntityWithUserId(userId)){
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
