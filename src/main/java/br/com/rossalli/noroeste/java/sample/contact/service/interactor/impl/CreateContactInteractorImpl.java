package br.com.rossalli.noroeste.java.sample.contact.service.interactor.impl;

import br.com.rossalli.noroeste.java.sample.contact.service.ContactService;
import br.com.rossalli.noroeste.java.sample.contact.service.interactor.CreateContactInteractor;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOIn;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateContactInteractorImpl implements CreateContactInteractor {

    private final ContactService contactService;

    @Override
    public ContactDTOOut execute(ContactDTOIn input) {
        return contactService.create(input);
    }
}

