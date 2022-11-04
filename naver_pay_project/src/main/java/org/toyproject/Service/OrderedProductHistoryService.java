package org.toyproject.Service;

import org.toyproject.DAO.OrderedProductHistoryDAO;
import org.toyproject.DTO.OrderedProductHistoryDTO;
import org.toyproject.Entity.OrderedProductHistoryEntity;

public class OrderedProductHistoryService {

    /*Entity를 DTO에 그대로 넣는다. (추가로 작업할게 없다)*/
    public OrderedProductHistoryDTO orderedProductHistory (String userId){
        OrderedProductHistoryDAO theDAO=OrderedProductHistoryDAO.getInstance();
        OrderedProductHistoryDTO theDTO=OrderedProductHistoryDTO.getInstance();
        if(theDAO.getOrderedProductHistoryEntityWithUserId(userId)!=null){
            OrderedProductHistoryEntity theEntity=theDAO.getOrderedProductHistoryEntityWithUserId(userId);
            /*User_info*/
            theDTO.setUserId(theEntity.getUserId());
            theDTO.setUserPoint(theEntity.getUserPoint());
            /*Product*/
            theDTO.setProductName(theEntity.getProductName());
            theDTO.setProductPrice(theEntity.getProductPrice());
            /*Company*/
            theDTO.setCompanyName(theEntity.getCompanyName());
            theDTO.setCompany_tel(theEntity.getCompany_tel());
            /*Order_info*/
            theDTO.setOrderId(theEntity.getOrderId());
            theDTO.setOrderDate(theEntity.getOrderDate());
            return theDTO;
        }
        return null;
    }
}
