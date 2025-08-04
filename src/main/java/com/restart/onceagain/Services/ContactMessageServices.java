package com.restart.onceagain.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restart.onceagain.Entites.ContactMessage;
import com.restart.onceagain.Repositroies.ContactMessageRepo;

@Service
public class ContactMessageServices {

    @Autowired
    private ContactMessageRepo contactMessageRepo;

    // Add a new contact message
    public ContactMessage addMessage(ContactMessage message) {
        return contactMessageRepo.save(message);
    }

    // Update an existing contact message by id

    public ContactMessage updateMessage(Long id, ContactMessage updatedMessage) {
    return contactMessageRepo.findById(id).map(message -> {
        message.setName(updatedMessage.getName());
        message.setEmail(updatedMessage.getEmail());
        message.setMessage(updatedMessage.getMessage());
        return contactMessageRepo.save(message);
    }).orElseThrow(() -> new RuntimeException("ContactMessage not found"));
}

    // Delete a contact message by id
    public boolean deleteMessage(Long id) {
        if (contactMessageRepo.existsById(id)) {
            contactMessageRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Get a contact message by id
    // public ContactMessage getMessage(Long id) {
    //     return contactMessageRepo.findById(id).orElse(null);
    // }

    // Get all contact messages
    public List<ContactMessage> getAllMessages() {
        return contactMessageRepo.findAll();
    }
  }

    // Additional methods can be added as needed