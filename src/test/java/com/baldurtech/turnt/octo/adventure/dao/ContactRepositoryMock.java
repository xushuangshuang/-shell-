package com.baldurtech.turnt.octo.adventure.dao;

import com.baldurtech.turnt.octo.adventure.domain.Contact;

public class ContactRepositoryMock implements ContactRepository {

    public Long getByIdActualParamId;
    public Contact getByIdShouldReturn;
    public boolean getByIdHasInvoked = false;
    public Long deleteByIdActualParamId;

    public Contact updateParamContact;

    public Contact getById(Long id) {
        getByIdActualParamId = id;
        getByIdHasInvoked = true;
        return getByIdShouldReturn;
    }

    public void deleteById(Long id) {
        deleteByIdActualParamId = id;
    }

    public void update(Contact contact) {
        updateParamContact = contact;
    }
}
