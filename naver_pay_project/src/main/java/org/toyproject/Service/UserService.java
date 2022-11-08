package org.toyproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toyproject.DAO.UserDAO;
import org.toyproject.DTO.UserDTO;
import org.toyproject.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
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
    public UserDTO login(String userId, String userPassword) {
        UserDTO userDTO = new UserDTO(userId, userPassword);
        if (userDTO == null) return null;

        UserEntity user = userDAO.select(userDTO.getUserId());//왜 null이 될까ㅏ..
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