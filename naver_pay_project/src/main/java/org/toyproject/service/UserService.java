package org.toyproject.service;

import org.springframework.stereotype.Service;
import org.toyproject.DAO.UserDAO;
import org.toyproject.DTO.UserDTO;
import org.toyproject.entity.UserEntity;

import java.util.List;
import org.toyproject.service.interfaces.UserServiceInterface;
@Service
public class UserService implements UserServiceInterface {
    private UserDAO userDAO = UserDAO.getInstance();

    private static UserService userService = null;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    @Override
    public List<UserDTO> findByUserIdOrEmail(String q) {
        return null;
    }

    @Override
    public boolean autoLogin(String autoLogin, String cookieId) {
        return false;
    }


    @Override
    public UserDTO Login(String userId, String userPassword) {
        UserDTO userDTO = new UserDTO(userId, userPassword);

        if (userDTO == null) return null;

        UserEntity user = userDAO.select(userDTO.getUserId(), userDTO.getUserPassword());//왜 null이 될까ㅏ..

        System.out.println(user);
        if (user == null || user.getUserPassword() == null) return null;
        if (user.getUserPassword().equals(userDTO.getUserPassword())) {

            return userDTO;
        }

        return null;
    }

    @Override
    public boolean signup(String userId, String userPassword, String uEmail) {
        return false;
    }

}