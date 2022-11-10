package org.toyproject.controller.nonlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.toyproject.service.CookieMgr;
import org.toyproject.service.SessionMgr;
import org.toyproject.service.UserService;


import javax.servlet.http.HttpSession;

@Controller
public class SignupController {
    private SessionMgr sessionMgr; //= SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private UserService userService; // = MemberService.getInstance();


    @Autowired
    public SignupController(SessionMgr sessionMgr, CookieMgr cookieMgr, UserService userService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        String view = "signup";

        if (session.getAttribute("SESSION_ID") != null) {
            view = "redirect:/";
        }

        return view;
    }

}
