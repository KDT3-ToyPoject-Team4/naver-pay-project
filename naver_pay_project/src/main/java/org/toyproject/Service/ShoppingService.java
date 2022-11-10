package org.toyproject.Service;

import org.toyproject.DAO.ShoppingDetailDAO;
import org.toyproject.Service.interfaces.Action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingService implements Action {


    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Message : ShoppingService의 execute() 호출");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        ActionForward forward = new ActionForward();
        if (id == null) {
            forward.setPath("./Longin");
            forward.setRedirect(true);
            return forward;
        }
        String orderId = request.getParameter("orderId");

        ShoppingDetailDAO sdao = new ShoppingDetailDAO();
        request.setAttribute("ShoppingDetailList", sdao.showShoppingDetail(Long.valueOf(orderId)));

        forward.setPath("./ShoppingDetail.jsp");
        forward.setRedirect(false);
        return forward;
    }
}