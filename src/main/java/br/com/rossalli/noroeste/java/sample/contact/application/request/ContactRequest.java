package br.com.rossalli.noroeste.java.sample.contact.application.request;

import br.com.rossalli.noroeste.java.sample.contact.domain.constant.ContactTypeEnum;
import br.com.rossalli.noroeste.java.sample.contact.service.dto.ContactDTOIn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest implements Serializable {

    @NotBlank
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String email;

    private String birthday;

    private ContactTypeEnum type;

    public ContactDTOIn toDTO() {
        ContactDTOIn contactDTOIn = new ContactDTOIn();
        contactDTOIn.setId(this.id);
        contactDTOIn.setName(this.name);
        contactDTOIn.setPhone(this.phone);
        contactDTOIn.setEmail(this.email);
        contactDTOIn.setBirthday(this.birthday);
        contactDTOIn.setType(this.type);
        return contactDTOIn;
    }

}

