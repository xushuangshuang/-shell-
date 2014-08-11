package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class DispatchServletTest extends MiniatureSpiceTestCase {

    DispatchServlet dispatchServlet = new DispatchServlet();
    String contactActionClassName = "com.baldurtech.turnt.octo.adventure.ContactAction";

    public void test_uri_contact_show_应该由ContactAction来处理() {
        assertEquals(contactActionClassName
                     , dispatchServlet.getActionClassNameByUri("/contact/show.jsp"));
    }

    public void test_uri_contact_应该由ContactAction来处理() {
        assertEquals(contactActionClassName
                     , dispatchServlet.getActionClassNameByUri("/contact"));
    }

    public void test_uri_contact_show_的处理方法是show() {
        assertEquals("show", dispatchServlet.getMethodNameByUri("/contact/show.jsp"));
    }

    public void test_uri_contact_的处理方法是index() {
        assertEquals("index", dispatchServlet.getMethodNameByUri("/contact"));
    }

    public void test_uri_contact_with_slash_suffix_的处理方法是index() {
        assertEquals("index", dispatchServlet.getMethodNameByUri("/contact/"));
    }
}
