package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactRepositoryTest extends MiniatureSpiceTestCase {

    public void test_根据指定id删除Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);

        contactRepository.deleteById(1L);

        assertEquals("DELETE FROM contact WHERE id=1", db.executeUpdateParam);
    }
}
