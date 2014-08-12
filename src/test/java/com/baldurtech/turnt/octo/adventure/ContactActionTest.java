package com.baldurtech.turnt.octo.adventure;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactActionTest extends MiniatureSpiceTestCase {

    public void test_show_当id为空的时候应该跳转到list() {
        ActionContextMock actionContext = new ActionContextMock();
        actionContext.setParameter("id", null);

        ContactAction action = new ContactAction(actionContext);

        action.show();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }
}
