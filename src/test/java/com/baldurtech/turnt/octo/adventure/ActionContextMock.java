package com.baldurtech.turnt.octo.adventure;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

public class ActionContextMock implements ActionContext {

    public String redirectActionParam;
    public String forwardActionParamUri;
    public Map<String, Object> forwardActionParamData = new HashMap<String, Object>();

    Map<String, String> params = new HashMap<String, String>();
    public void setParameter(String name, String value) {
        params.put(name, value);
    }

    public String getParameter(String name) {
        return params.get(name);
    }

    public void redirectAction(String actionUri) {
        this.redirectActionParam = actionUri;
    }

    public void forwardAction(String uri, Map<String, Object> data) {
        forwardActionParamUri = uri;
        forwardActionParamData = data;
    }

    public PrintWriter getOut() throws IOException {
        return new PrintWriter(new StringWriter());
    }

    public void setAttribute(String key, Object value) {

    }
}
