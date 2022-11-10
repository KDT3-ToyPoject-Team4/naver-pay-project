package org.toyproject.Service.interfaces;

import org.toyproject.DTO.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> findByUserIdOrEmail(String q);

    boolean autoLogin(String autoLogin, String cookieId);


    UserDTO login(String uId, String uPw);

    boolean signup(String uId, String uPw, String uEmail);

}
