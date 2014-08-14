package com.baldurtech.turnt.octo.adventure.manager;

import com.baldurtech.turnt.octo.adventure.domain.Contact;

public class ContactManagerMock implements ContactManager {
    public Long getByIdActualParamId;
    public Contact getByIdShouldReturn;
    public Contact saveShouldReturn;

    public Contact getById(Long id) {
        getByIdActualParamId = id;
        return getByIdShouldReturn;
    }

    public Contact save(Contact contact) {
        return saveShouldReturn;
    }
}
