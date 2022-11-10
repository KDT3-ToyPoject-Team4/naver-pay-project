package org.toyproject.DAO;

import org.toyproject.DTO.ShoppingDetailDTO;
import org.toyproject.DTO.UserDTO;

import java.util.Arrays;
import java.util.List;

public class DAOtest {
    public static void main(String[] args) {
        UserInfo();
        ShoppingDetailDAO detailDAO = new ShoppingDetailDAO();
        ShoppingDetailDTO shoppingDetailDTO = detailDAO.showShoppingDetail(2L);
        System.out.println(shoppingDetailDTO.toString());
    }

    public static void UserInfo() {
        UserDAO userDAO = new UserDAO();
        List<UserDTO> res = userDAO.searchUserALL();
        for (UserDTO user : res) {
            System.out.println(user.toString());
        }

        UserDTO res2 = userDAO.searchUser("id", "pw");
        System.out.println(res2);
    }

}
