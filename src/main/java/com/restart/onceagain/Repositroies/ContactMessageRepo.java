package com.restart.onceagain.Repositroies;
import com.restart.onceagain.Entites.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactMessageRepo extends JpaRepository<ContactMessage, Long> {
    // Additional query methods can be defined here if needed

}
