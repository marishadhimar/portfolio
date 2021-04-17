package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.domain.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Optional<Contact> getContact(Long contactId);

    List<Contact> getAllContacts();
}
