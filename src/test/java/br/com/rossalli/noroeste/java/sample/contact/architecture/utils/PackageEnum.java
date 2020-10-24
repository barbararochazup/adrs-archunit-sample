package br.com.rossalli.noroeste.java.sample.contact.architecture.utils;

import lombok.Getter;

public enum PackageEnum {

    BASE_PACKAGE("br.com.rossalli.noroeste.java.sample.contact"),
    APPLICATION_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.application"),
    DOMAIN_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.domain"),
    SERVICE_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.service"),
    CONTROLLER_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.application.controller"),
    REQUEST_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.application.request"),
    RESPONSE_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.application.response"),
    ENTITY_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.domain.entity"),
    REPOSITORY_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.domain.repository"),
    DTO_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.service.dto"),
    INTERACTOR_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.service.interactor"),
    INTERACTOR_IMPL_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.service.interactor.impl"),
    ARCHITECTURE_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.architecture"),
    ARCHITECTURE_RULES_PACKAGE("br.com.rossalli.noroeste.java.sample.contact.architecture.rules"),
    ARCHITECTURE_UTILS("br.com.rossalli.noroeste.java.sample.contact.architecture.utils");

    @Getter
    private String packagePath;

    PackageEnum(String packagePath) {
        this.packagePath = packagePath;
    }
}
