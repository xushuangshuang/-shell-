package com.baldurtech.turnt.octo.adventure;

import java.util.Map;
import java.util.HashMap;

public class ContactAction extends Action {
    public ContactAction(ActionContext actionContext) {
        super(actionContext);
    }

    public void index() {
        println("Hi, contact!");
    }

    public Map<String, Object> show() {
        return new HashMap<String, Object>();
    }
}
