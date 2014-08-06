package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactRepositoryTest extends MiniatureSpiceTestCase {

    public void test_根据指定id删除Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);

        contactRepository.deleteById(1L);

        assertEquals("DELETE FROM contact WHERE id=1", db.executeUpdateParam);
    }

    public void test_更新指定的Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("Tom Hanks");
        contact.setMobile("13900001111");
        contact.setEmail("tom@baldurtech.com");

        contactRepository.update(contact);

        assertEquals("UPDATE contact SET email=?, home_address=?, job=?, job_level=?, memo=?, mobile=?, name=?, office_address=?, vpmn=? WHERE id=?", db.executeUpdateParam);
        assertArrayEquals(new Object[]{"tom@baldurtech.com", null, null, null, null, "13900001111", "Tom Hanks", null, null, 1L}, db.executeUpdateParam2);
    }
}
