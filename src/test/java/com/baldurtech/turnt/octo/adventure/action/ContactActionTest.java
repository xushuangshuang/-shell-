package com.baldurtech.turnt.octo.adventure.action;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import com.baldurtech.turnt.octo.adventure.manager.ContactManagerMock;
import com.baldurtech.turnt.octo.adventure.domain.Contact;

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

    public void test_show_当id有效且对应的Contact存在时应该正常显示() {
        contactManager.getByIdShouldReturn = createPersistentContactWithId(1L);

        actionContext.setParameter("id", "1");

        Map<String, Object> result = action.show();

        assertTrue(null == actionContext.redirectActionParam);
        assertEquals(1L, ((Contact)result.get("contact")).getId());
    }

    public void test_show_当id有效但对应的Contact不存在时应该跳转到list() {
        actionContext.setParameter("id", "1");

        Map<String, Object> result = action.show();

        assertEquals(1L, contactManager.getByIdActualParamId);
        assertEquals("contact/list", actionContext.redirectActionParam);
    }

    public void test_save_保存成功后要跳转到list() {
        contactManager.saveShouldReturn = createPersistentContactWithId(1L);

        action.save();

        assertEquals("contact/show?id=1", actionContext.redirectActionParam);
    }

    public void test_save_保存失败后要返回到创建页面重新修改() {
        actionContext.setParameter("jobLevel", "  ");

        contactManager.saveShouldReturn = new Contact();

        action.save();

        assertEquals("contact/create", actionContext.forwardActionParamUri);
        assertTrue(null != actionContext.forwardActionParamData.get("contact"));
        assertEquals("Cannot save Contact!", actionContext.flashMessageParamMsg);
    }

    public void test_index_应该始终跳转到list() {
        action.index();

        assertEquals("contact/list", actionContext.redirectActionParam);
    }

    public Contact createPersistentContactWithId(Long id) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setPersistent(true);

        return contact;
    }
}
