package org.toyproject.service;

import org.toyproject.DAO.ShoppingDetailDAO;
import org.toyproject.DTO.ShoppingDetailDTO;

public class ShoppingService {
    private static ShoppingDetailDAO shoppingDetailDAO;
    public ShoppingDetailDTO showShoppingDetail(long orderId) {
        ShoppingDetailDTO shoppingDetailDTO = shoppingDetailDAO.showShoppingDetail(orderId);

        return shoppingDetailDTO;
    }

}