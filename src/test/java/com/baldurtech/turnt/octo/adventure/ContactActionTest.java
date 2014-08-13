package com.baldurtech.turnt.octo.adventure;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactActionTest extends MiniatureSpiceTestCase {

    public void test_show_当id为空的时候应该跳转到list() {
        ContactManagerMock contactManager = new ContactManagerMock();

        ActionContextMock actionContext = new ActionContextMock();
        actionContext.setParameter("id", null);

        ContactAction action = new ContactAction(actionContext, contactManager);

        action.show();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }

    public void test_save_保存成功后要跳转到list() {
        ActionContextMock actionContext = new ActionContextMock();
        actionContext.setParameter("id", null);

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setPersistent(true);

        ContactManagerMock contactManager = new ContactManagerMock();
        contactManager.saveShouldReturn = contact;

        ContactAction action = new ContactAction(actionContext, contactManager);

        action.save();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }
}
