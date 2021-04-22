package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.Contact;
import com.marishadhimar.portfolio.dto.ContactDTO;
import com.marishadhimar.portfolio.mapper.ContactMapper;
import com.marishadhimar.portfolio.repository.ContactRepository;
import com.marishadhimar.portfolio.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDTO getContact(Long contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isPresent()) {
            return ContactMapper.INSTANCE.toContactDTO(optionalContact.get());
        } else {
            throw new RuntimeException("Contact with id " + contactId + " was not found!");
        }
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contactList = contactRepository.findAll();
        return ContactMapper.INSTANCE.toContactDTOList(contactList);
    }

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toContact(contactDTO);
        Contact persistedContact = contactRepository.save(contact);
        return ContactMapper.INSTANCE.toContactDTO(persistedContact);
    }

    @Override
    public ContactDTO updateContact(Long contactId, ContactDTO contactDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setEmail(contactDTO.getEmail());
            contact.setName(contactDTO.getName());
            contact.setSubject(contactDTO.getSubject());
            Contact persistenceContact = contactRepository.save(contact);
            return ContactMapper.INSTANCE.toContactDTO(persistenceContact);
        } else {
            throw new RuntimeException("Contact with id " + contactId + " was not found!");
        }
    }

    @Override
    public void deleteContact(Long contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isPresent()) {
            contactRepository.delete(optionalContact.get());
        } else {
            throw new RuntimeException("Contact with id " + contactId + " was not found!");
        }
    }
}
