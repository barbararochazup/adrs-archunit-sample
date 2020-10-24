package br.com.rossalli.noroeste.java.sample.contact.application.response;

import br.com.rossalli.noroeste.java.sample.contact.domain.constant.ContactTypeEnum;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOOut;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ContactResponse implements Serializable {

    private UUID id;

    private String name;

    private String phone;

    private String email;

    private String birthday;

    private ContactTypeEnum type;

    public static ContactResponse fromDTO(ContactDTOOut contactDTOOut) {
        ContactResponse response = new ContactResponse();
        response.setId(contactDTOOut.getId());
        response.setName(contactDTOOut.getName());
        response.setPhone(contactDTOOut.getPhone());
        response.setEmail(contactDTOOut.getEmail());
        response.setBirthday(contactDTOOut.getBirthday());
        response.setType(contactDTOOut.getType());
        return response;
    }
}
