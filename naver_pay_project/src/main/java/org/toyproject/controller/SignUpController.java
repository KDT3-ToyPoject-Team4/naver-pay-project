package org.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public String signup(){
        return "SignUp";      // WEB-INF/views/SignUp.jsp
    }


    @RequestMapping("/sign/success")
    public String success(){

        return "index";
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
