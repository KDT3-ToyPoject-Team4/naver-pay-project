package org.toyproject.controller.nonlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.toyproject.DTO.UserDTO;
import org.toyproject.service.CookieMgr;
import org.toyproject.service.SessionMgr;
import org.toyproject.service.UserService;
import org.toyproject.controller.login.Status;

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

    @GetMapping("/Login")
    public String LoginPage(HttpServletRequest request, HttpSession session) {
        String view = "Login";

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

    @PostMapping("/Login")
    public String doLogin(@RequestParam String userId,
                          @RequestParam String userPassword,
                          @RequestParam(required = false) String save,
                          Model model, HttpServletRequest request,
                          HttpSession session,
                          HttpServletResponse response) {
        //@RequestParam으로 아이디(id)와 패스워드(pwd)를 받는데
        // 이렇게 선언을 할 경우 해당 파라미터가 전달되지 않을 경우 에러가 발생한다.
        // 그래서 파라미터가 타입에 맞게 꼭 전달해야 되는 경우
        // 이런식으로 파라미터를 선언하게 되면 알아서 형변환이 되어 변수로 사용할 수 있고 편리하다.



        String view = LoginPage(request, session); // Login.jsp
        Status respStatus = Status.FAIL;

        UserDTO userDTO = userService.Login(userId, userPassword);
        //Login.jsp에서 가져온 ID와 PW를 userService의 login 메소드를 사용해 userDTO에 정보를 담는다.
        System.out.println(userDTO);

        if (userDTO != null) { //userDTO에 정보가 담겨 있을 때

            sessionMgr.create(session, userId); //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관

            model.addAttribute("userId", session.getAttribute("SESSION_ID"));

            view = "MyInfo";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("Login", respStatus);
        return view;
    }




}
