package org.toyproject.service.interfaces;

import org.toyproject.service.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception;
}
