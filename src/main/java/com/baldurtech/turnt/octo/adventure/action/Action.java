package com.baldurtech.turnt.octo.adventure.action;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

    final ActionContext actionContext;

    public Action(ActionContext actionContext) {
        this.actionContext = actionContext;
    }

    public void setAttribute(String key, Object value) {
        actionContext.setAttribute(key, value);
    }

    public void println(String str) {
        try {
            actionContext.getOut().println(str);
        } catch(IOException e) {
        }
    }
}
