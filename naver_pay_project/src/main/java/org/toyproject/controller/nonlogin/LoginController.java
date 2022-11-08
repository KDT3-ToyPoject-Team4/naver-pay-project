package org.toyproject.controller.nonlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.toyproject.DTO.UserDTO;
import org.toyproject.cookies.CookieMgr;
import org.toyproject.sessions.SessionMgr;
import org.toyproject.Service.UserService;
import org.toyproject.utils.Status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private UserService userService ; //= MemberService.getInstance();


    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, UserService userService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        String view = "login";

        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
            return "redirect:/";
        }

        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
        String cookieId = cookieMgr.get(request, "COOKIE_ID");


        if (autoLogin != null && cookieId != null) {
            if (userService.autoLogin(autoLogin, cookieId)) {
                sessionMgr.create(session, cookieId);
                view = "redirect:/";
            }
        }

        return view;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String userId,
                          @RequestParam String userPassword,
                          @RequestParam(required = false) String save,
                          Model model, HttpServletRequest request,
                          HttpSession session,
                          HttpServletResponse response) {

        String view = loginPage(request, session); // login.jsp
        Status respStatus = Status.FAIL;

        UserDTO userDTO = userService.login(userId, userPassword);
        System.out.println(userDTO);
        if (userDTO != null) {
            sessionMgr.create(session, userId);

            model.addAttribute("userId", session.getAttribute("SESSION_ID"));

            view = "LoginSucceed";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("login", respStatus);
        return view;
    }

}



