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

    public String defaultPackageName = "com.baldurtech.turnt.octo.adventure";
    public String defaultSuffix = ".jsp";

    public String getActionClassNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName = capitalize(removeDefaultSuffix(uriParts[indexOfActionClassName]));
        return defaultPackageName + "." + actionClassName + "Action";
    }

    public String getMethodNameByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfMethodName = 2;
        if(uriParts.length <= indexOfMethodName) {
            return "index";
        }
        return removeDefaultSuffix(uriParts[indexOfMethodName]);
    }

    public String getViewPage(String uri) {
        return "/WEB-INF/jsp" + uri;
    }

    public String[] splitBySlash(String uri) {
        return uri.split("/");
    }

    public String removeDefaultSuffix(String str) {
        return str.replace(defaultSuffix, "");
    }

    public String capitalize(String str) {
        return str.substring(0, 1).toUpperCase()
            + str.substring(1);
    }
}
