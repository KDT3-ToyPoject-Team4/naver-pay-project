package org.toyproject.Service;

import org.toyproject.DTO.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findByUserIdOrEmail(String q);

    boolean autoLogin(String autoLogin, String cookieId);


    UserDTO login(String uId, String uPw);

    boolean signup(String uId, String uPw, String uEmail);

}
