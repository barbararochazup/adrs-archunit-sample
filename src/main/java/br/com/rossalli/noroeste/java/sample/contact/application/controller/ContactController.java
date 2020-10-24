package br.com.rossalli.noroeste.java.sample.contact.application.controller;

import br.com.rossalli.noroeste.java.sample.contact.application.request.ContactRequest;
import br.com.rossalli.noroeste.java.sample.contact.application.response.ContactResponse;
import br.com.rossalli.noroeste.java.sample.contact.service.interactor.CreateContactInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactController {

    private final CreateContactInteractor createContactInteractor;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse create(@RequestBody ContactRequest request) {
        return ContactResponse.fromDTO(createContactInteractor.execute(request.toDTO()));
    }
}
