package com.baldurtech.turnt.octo.adventure;

import java.io.PrintWriter;
import java.util.Map;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionContext {
    public PrintWriter getOut() throws IOException;
    public void setAttribute(String key, Object value);
    public String getParameter(String name);
    public void redirectAction(String actionUri);
    public void forwardAction(String uri, Map<String, Object> data);
    public void flashMessage(String msg);
}
