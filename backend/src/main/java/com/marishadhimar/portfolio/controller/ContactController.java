package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.ContactDTO;
import com.marishadhimar.portfolio.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/getContact/{contactId}", method = RequestMethod.GET)
    ResponseEntity<ContactDTO> getContact(@PathVariable Long contactId) {
        return new ResponseEntity<>(contactService.getContact(contactId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllContact", method = RequestMethod.GET)
    ResponseEntity<List<ContactDTO>> getAllContact() {
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<>(contactService.createContact(contactDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateContact/{contactId}", method = RequestMethod.PUT)
    ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO contactDTO, @PathVariable Long contactId) {
        return new ResponseEntity<>(contactService.updateContact(contactId, contactDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteContact/{contactId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
