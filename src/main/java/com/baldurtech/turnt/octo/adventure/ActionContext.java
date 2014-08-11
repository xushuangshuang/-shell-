package com.baldurtech.turnt.octo.adventure;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionContext {
    public PrintWriter getOut() throws IOException;
    public void setAttribute(String key, Object value);
}
