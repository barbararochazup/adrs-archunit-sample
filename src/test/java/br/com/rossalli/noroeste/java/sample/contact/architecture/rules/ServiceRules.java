package br.com.rossalli.noroeste.java.sample.contact.architecture.rules;

import br.com.rossalli.noroeste.java.sample.contact.architecture.utils.ArchConditionCustom;
import br.com.rossalli.noroeste.java.sample.contact.architecture.utils.PackageEnum;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class ServiceRules {

    @ArchTest
    static ArchRule dtos_should_be_in_service_dto_package =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("DTO")
                    .should().resideInAPackage(PackageEnum.DTO_PACKAGE.getPackagePath());

    @ArchTest
    static ArchRule service_should_be_in_service_package =
            ArchRuleDefinition.classes().that()
                    .resideOutsideOfPackages(PackageEnum.ARCHITECTURE_PACKAGE.getPackagePath(), PackageEnum.ARCHITECTURE_RULES_PACKAGE.getPackagePath(), PackageEnum.ARCHITECTURE_UTILS.getPackagePath())
                    .and().haveSimpleNameContaining("Service")
                    .should().resideInAPackage(PackageEnum.SERVICE_PACKAGE.getPackagePath());

    @ArchTest
    static ArchRule interactor_should_be_in_service_interactor_package =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Interactor")
                    .should().resideInAPackage(PackageEnum.INTERACTOR_PACKAGE.getPackagePath());

    @ArchTest
    static ArchRule interactor_impl_should_be_in_service_interactor_impl_package =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("Impl")
                    .should().resideInAPackage(PackageEnum.INTERACTOR_IMPL_PACKAGE.getPackagePath());
    @ArchTest
    static ArchRule interactor_impl_should_be_annotated_with_component =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("Impl")
                    .should().beAnnotatedWith(Component.class);

    @ArchTest
    static ArchRule interactor_should_be_interfaces =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Interactor")
                    .should().beInterfaces();

    @ArchTest
    static ArchRule interactor_classes_should_be_only_method_classes =
            ArchRuleDefinition.classes().that().resideInAPackage(PackageEnum.INTERACTOR_PACKAGE.getPackagePath())
                    .should(ArchConditionCustom.containOnlyOnePublicMethod());
    @ArchTest
    static ArchRule dto_in_should_be_to_entity_method =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("DTOIn")
                    .should(ArchConditionCustom.containspecificmethod("toEntity"));
    @ArchTest
    static ArchRule dto_out_should_be_from_dto_method =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("DTOOut")
                    .should(ArchConditionCustom.containspecificmethod("fromEntity"));

    @ArchTest
    static ArchRule interactor_should_be_inject_only_one_service_class =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameContaining("Impl")
                    .should(ArchConditionCustom.injectOnlyType("Service"));
    @ArchTest
    static ArchRule service_classes_should_be_named_x_service =
            ArchRuleDefinition.classes().that()
                    .areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("Service");

    @ArchTest
    static ArchRule request_classes_should_be_named_x_request =
            ArchRuleDefinition.classes().that()
                    .resideInAPackage(PackageEnum.DTO_PACKAGE.getPackagePath())
                    .should().haveSimpleNameContaining("DTO");

    @ArchTest
    static ArchRule interactor_classes_should_be_named_x_interactor =
            ArchRuleDefinition.classes().that()
                    .resideInAPackage(PackageEnum.INTERACTOR_PACKAGE.getPackagePath())
                    .should().haveSimpleNameEndingWith("Interactor");

    @ArchTest
    static ArchRule interactor_impl_classes_should_be_named_x_interactor_impl =
            ArchRuleDefinition.classes().that()
                    .resideInAPackage(PackageEnum.INTERACTOR_IMPL_PACKAGE.getPackagePath())
                    .should().haveSimpleNameEndingWith("InteractorImpl");


}
