package com.baldurtech.turnt.octo.adventure;

public class ContactAction extends Action {
    public ContactAction(ActionContext actionContext) {
        super(actionContext);
    }

    public void index() {
        println("Hi, contact!");
    }
}
