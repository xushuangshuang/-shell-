package com.baldurtech.turnt.octo.adventure;

public class ContactRepository {

    private DatabaseManager db;

    public ContactRepository(DatabaseManager db) {
        this.db = db;
    }

    public void deleteById(Long id) {
        db.executeUpdate("DELETE FROM contact WHERE id=" + id);
    }

    public void update(Contact contact) {

    }
}
