package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.turnt.octo.adventure.domain.Contact;

public class ContactManagerMock implements ContactManager {
    public Contact getByIdShouldReturn;
    public Contact saveShouldReturn;

    public Contact getById(Long id) {
        return getByIdShouldReturn;
    }

    public Contact save(Contact contact) {
        return saveShouldReturn;
    }
}
