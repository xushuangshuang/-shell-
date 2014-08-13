package com.baldurtech.turnt.octo.adventure.action;

import java.io.PrintWriter;
import java.util.Map;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContextImpl implements ActionContext {

    final ServletContext servletContext;
    final HttpServletRequest request;
    final HttpServletResponse response;

    String contextPath = "";

    public ActionContextImpl(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;

        if(null != request) {
            contextPath = request.getContextPath();
        }
    }

    public PrintWriter getOut() throws IOException {
        return response.getWriter();
    }

    public void setAttribute(String key, Object value) {
        request.setAttribute(key, value);
    }

    public String getParameter(String name) {
        return request.getParameter(name);
    }

    public void redirectAction(String actionUri) {
        try {
            response.sendRedirect(toRealUri(actionUri));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String toRealUri(String actionUri) {
        if(actionUri.indexOf("?") > 0) {
            return contextPath + "/" + actionUri.replace("?", ".do?");
        }
        return contextPath + "/" + actionUri + ".do";
    }

    public void forwardAction(String uri, Map<String, Object> data) {
        try {
            for(String key: data.keySet()) {
                request.setAttribute(key, data.get(key));
            }

            servletContext.getRequestDispatcher("/" + uri + ".do").forward(request, response);
        } catch(IOException ie) {

        } catch(ServletException se) {

        }
    }

    public void flashMessage(String msg) {
        request.setAttribute("flash.message", msg);
    }
}
