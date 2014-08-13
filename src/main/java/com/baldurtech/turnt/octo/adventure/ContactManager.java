package com.baldurtech.turnt.octo.adventure;

public interface ContactManager {
    public Contact getById(Long id);
    public Contact save(Contact contact);
}
