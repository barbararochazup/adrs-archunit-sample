package br.com.rossalli.noroeste.java.sample.contact.service.dto;

import br.com.rossalli.noroeste.java.sample.contact.domain.constant.ContactTypeEnum;
import br.com.rossalli.noroeste.java.sample.contact.domain.entity.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ContactDTOIn implements Serializable {

    @NotBlank
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String email;

    private String birthday;

    @NotBlank
    private ContactTypeEnum type;

    public Contact toEntity() {
        Contact contact = new Contact();
        contact.setId(this.id);
        contact.setName(this.name);
        contact.setPhone(this.phone);
        contact.setEmail(this.email);
        contact.setBirthday(this.birthday);
        contact.setType(this.type);
        return contact;
    }

}

