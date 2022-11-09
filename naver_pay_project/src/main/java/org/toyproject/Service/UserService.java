package org.toyproject.Service;

import org.springframework.stereotype.Service;
import org.toyproject.DAO.UserDAO;
import org.toyproject.DTO.UserDTO;
import org.toyproject.Entity.UserEntity;

import java.util.List;

@Service
public class UserService implements org.toyproject.Service.interfaces.UserServiceInterface {
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
    public void signUp(UserDTO tempDTO){
        UserDAO theDAO = new UserDAO();

        String userId= tempDTO.getUserId();
        String userPassword = tempDTO.getUserPassword();
        String userName = tempDTO.getUserName();
        String userPhoneNumber = tempDTO.getUserPhoneNumber();
        String userAddress = tempDTO.getUserAddress();
        System.out.println("Service" + userId);
        UserEntity userEntity = new UserEntity(userId, userPassword, userName, userPhoneNumber, userAddress, "0");
        if (userEntity != null) {
            theDAO.insertUser(userEntity);
        }

    }
    // 회원가입 입력값??

    @Override
    public UserDTO login(String userId, String userPassword) {
        UserDTO userDTO = new UserDTO(userId, userPassword);
        if (userDTO == null) return null;


        UserEntity user = userDAO.select(userDTO.getUserId(), userDTO.getUserPassword());//왜 null이 될까ㅏ..
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