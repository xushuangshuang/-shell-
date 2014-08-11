package com.baldurtech.turnt.octo.adventure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

    }

    public String getActionClassNameByUri(String uri) {
        String[] uriParts = uri.split("/");
        Integer indexOfActionClassName = 1;
        String actionClassName = uriParts[indexOfActionClassName];
        actionClassName = actionClassName.substring(0, 1).toUpperCase()
            + actionClassName.substring(1);
        return "com.baldurtech.turnt.octo.adventure." + actionClassName + "Action";
    }
}
