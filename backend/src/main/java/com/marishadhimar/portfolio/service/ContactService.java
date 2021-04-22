package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    ContactDTO getContact(Long contactId);

    List<ContactDTO> getAllContacts();

    ContactDTO createContact(ContactDTO contactDTO);

    ContactDTO updateContact(Long contactId, ContactDTO contactDTO);

    void deleteContact(Long contactId);
}
