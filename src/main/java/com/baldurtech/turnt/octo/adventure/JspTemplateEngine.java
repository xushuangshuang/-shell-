package com.baldurtech.turnt.octo.adventure;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspTemplateEngine implements TemplateEngine {

    private final ServletContext servletContext;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public JspTemplateEngine(ServletContext servletContext
                             , HttpServletRequest request
                             , HttpServletResponse response) {
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

    public void merge(String page, Object  data) {
        try {
            if(data instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> dataModel = (Map<String, Object>)data;
                for(String key: dataModel.keySet()) {
                    request.setAttribute(key, dataModel.get(key));
                }
            } else {
                request.setAttribute("data", data);
            }
            servletContext
                .getRequestDispatcher(page)
                .forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
