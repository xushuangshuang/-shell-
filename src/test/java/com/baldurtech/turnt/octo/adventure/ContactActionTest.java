package com.baldurtech.turnt.octo.adventure;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactActionTest extends MiniatureSpiceTestCase {

    ContactManagerMock contactManager;

    ActionContextMock actionContext;

    ContactAction action;

    public void setup() {
        contactManager = new ContactManagerMock();

        actionContext = new ActionContextMock();

        action = new ContactAction(actionContext, contactManager);
    }

    public void test_show_当id为空的时候应该跳转到list() {
        action.show();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }

    public void test_save_保存成功后要跳转到list() {
        contactManager.saveShouldReturn = createPersistentContactWithId(1L);

        action.save();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }

    public void test_save_保存失败后要返回到创建页面重新修改() {
        actionContext.setParameter("jobLevel", "  ");

        contactManager.saveShouldReturn = new Contact();

        action.save();

        assertEquals("contact/create", actionContext.forwardActionParamUri);
        assertTrue(null != actionContext.forwardActionParamData.get("contact"));
        assertEquals("Cannot save Contact!", actionContext.flashMessageParamMsg);
    }

    public Contact createPersistentContactWithId(Long id) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setPersistent(true);

        return contact;
    }
}
