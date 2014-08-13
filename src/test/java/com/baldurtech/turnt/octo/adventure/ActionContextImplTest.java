package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ActionContextImplTest extends MiniatureSpiceTestCase {

    ActionContextImpl actionContext = new ActionContextImpl(null, null, null);

    public void test_toRealUri_不带参数的actionUri() {
        assertEquals("contact/list.do", actionContext.toRealUri("contact/list"));
    }

    public void test_toRealUri_contact_show带参数的actionUri() {
        assertEquals("contact/show.do?id=1", actionContext.toRealUri("contact/show?id=1"));
    }
}
