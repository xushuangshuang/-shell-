package com.baldurtech.turnt.octo.adventure;

import com.baldurtech.turnt.octo.adventure.domain.Contact;

public interface ContactManager {
    public Contact getById(Long id);
    public Contact save(Contact contact);
}
