package br.com.rossalli.noroeste.java.sample.contact.service;

import br.com.rossalli.noroeste.java.sample.contact.domain.repository.ContactRepository;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOIn;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactDTOOut create(ContactDTOIn input) {
        return ContactDTOOut.fromEntity(contactRepository.save(input.toEntity()));
    }
}
