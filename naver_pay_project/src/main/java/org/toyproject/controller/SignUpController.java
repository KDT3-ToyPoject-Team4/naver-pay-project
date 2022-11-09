package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.toyproject.DAO.UserDAO;
import org.toyproject.DTO.UserDTO;
import org.toyproject.Entity.UserEntity;
import org.toyproject.Service.UserService;

@Controller
public class SignUpController {
    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public String signup(){
        return "SignUp";      // WEB-INF/views/SignUp.jsp
    }


    @RequestMapping("/login")
    public String success(@RequestParam("userID") String userId,
                          @RequestParam("userPassword") String userPassword,
                          @RequestParam("userName") String userName,
                          @RequestParam("userPhoneNumber") String userPhoneNumber,
                          @RequestParam("userAddress") String userAddress){
//        userId=lala9663

        UserDTO signDTO = new UserDTO();
        UserService theService = new UserService();
        UserDAO theDAO = new UserDAO();


        theDAO.insertUser(theService.signUp(signDTO));


        return "Login";
    }



//    @PostMapping("/register/save")
//    public String save(User user, Model m) throws Exception{
//        if (!isValid(user)){
//            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//
//            m.addAttribute("msg", msg);
//            return "redirect:/register/add";
//        }
//        return "registerInfo";
//    }
//
//    private boolean isValid(User user) {
//        return true;
//    }

}
