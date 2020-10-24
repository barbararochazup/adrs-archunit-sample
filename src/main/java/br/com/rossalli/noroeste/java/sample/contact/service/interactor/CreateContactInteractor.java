package br.com.rossalli.noroeste.java.sample.contact.service.interactor;

import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOIn;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOOut;

public interface CreateContactInteractor {
    ContactDTOOut execute(ContactDTOIn input);
}
