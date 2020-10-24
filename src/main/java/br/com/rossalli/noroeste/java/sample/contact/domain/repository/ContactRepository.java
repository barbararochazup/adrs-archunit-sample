package br.com.rossalli.noroeste.java.sample.contact.domain.repository;

import br.com.rossalli.noroeste.java.sample.contact.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}