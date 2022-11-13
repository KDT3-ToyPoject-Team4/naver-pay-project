package org.toyproject.service;

import org.toyproject.DAO.ShoppingDetailDAO;
import org.toyproject.DTO.ShoppingDetailDTO;

public class ShoppingService{

    private static ShoppingDetailDAO shoppingDetailDAO = ShoppingDetailDAO.getInstance();
    public ShoppingDetailDTO showShoppingDetail(long orderId) {
        System.out.println(shoppingDetailDAO.showShoppingDetail(orderId));
        return shoppingDetailDAO.showShoppingDetail(orderId);
    }

    public void deleteShoppingDetail(Long orderId){
        shoppingDetailDAO.deleteShoppingDetail(orderId);
    }
}