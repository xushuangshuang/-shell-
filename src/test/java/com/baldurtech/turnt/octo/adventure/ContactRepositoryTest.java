package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ContactRepositoryTest extends MiniatureSpiceTestCase {

    public void test_根据指定id删除Contact() {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);

        contactRepository.deleteById(1L);

        assertEquals("DELETE FROM contact where id=1", db.executeUpdateParam);
    }
}

class DatabaseManagerMock implements DatabaseManager {
    public String executeUpdateParam;
    public int executeUpdateShouldReturn = 0;

    public int executeUpdate(String sql) {
        executeUpdateParam = sql;
        return executeUpdateShouldReturn;
    }
}
