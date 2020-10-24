package br.com.rossalli.noroeste.java.sample.contact.domain.entity;

import br.com.rossalli.noroeste.java.sample.contact.domain.constant.ContactTypeEnum;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min = 3, max = 200)
    @NotBlank
    private String name;

    @Max(value = 200)
    private String nickname;

    @NotBlank
    @Size(min = 11, max = 12)
    private String phone;

    @Size(min = 15, max = 200)
    private String email;

    private String birthday;

    @Enumerated(EnumType.STRING)
    private ContactTypeEnum type;

    private boolean active;

    @PrePersist
    private void prePersist() {
        this.active = true;
    }

}
