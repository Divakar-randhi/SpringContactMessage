package com.restart.onceagain.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restart.onceagain.Entites.ContactMessage;
import com.restart.onceagain.Services.ContactMessageServices;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageServices contactMessageServices;

    // Add a new contact message
    @PostMapping
    public ContactMessage addMessage(@RequestBody ContactMessage message) {
        return contactMessageServices.addMessage(message);
    }

    // Update an existing contact message
   @PutMapping("/{id}")
    public ContactMessage updateMessage(@PathVariable Long id, @RequestBody ContactMessage message) {
        return contactMessageServices.updateMessage(id, message);
    }

    // Delete a contact message by id
    @DeleteMapping("/{id}")
    public boolean deleteMessage(@PathVariable Long id) {
        return contactMessageServices.deleteMessage(id);
    }

    // Get a contact message by id
    // Uncomment if needed

    // Get all contact messages
    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageServices.getAllMessages();
    }
}