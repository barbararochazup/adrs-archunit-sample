package br.com.rossalli.noroeste.java.sample.contact.service.dto;

import br.com.rossalli.noroeste.java.sample.contact.domain.constant.ContactTypeEnum;
import br.com.rossalli.noroeste.java.sample.contact.domain.entity.Contact;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTOOut implements Serializable {

    private UUID id;

    private String name;

    private String phone;

    private String email;

    private String birthday;

    private ContactTypeEnum type;

    public static ContactDTOOut fromEntity(Contact contact) {
        ContactDTOOut contactDTOOut = new ContactDTOOut();
        contactDTOOut.setId(contact.getId());
        contactDTOOut.setName(contact.getName());
        contactDTOOut.setPhone(contact.getPhone());
        contactDTOOut.setEmail(contact.getEmail());
        contactDTOOut.setBirthday(contact.getBirthday());
        contactDTOOut.setType(contact.getType());
        return contactDTOOut;

    }
}