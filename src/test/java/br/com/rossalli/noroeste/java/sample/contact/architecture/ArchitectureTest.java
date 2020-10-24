package br.com.rossalli.noroeste.java.sample.contact.architecture;

import br.com.rossalli.noroeste.java.sample.contact.architecture.rules.ApplicationRules;
import br.com.rossalli.noroeste.java.sample.contact.architecture.rules.DomainRules;
import br.com.rossalli.noroeste.java.sample.contact.architecture.rules.ServiceRules;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import com.tngtech.archunit.library.dependencies.SliceRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "br.com.rossalli.noroeste.java.sample.contact")
public class ArchitectureTest {

    @ArchTest
    static ArchRule dependency_injection_only_by_constructor =
            GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    SliceRule dependency_cycle = SlicesRuleDefinition.slices()
            .matching("..(*)")
            .should()
            .beFreeOfCycles();

    @ArchTest
    static ArchRules applicationRules = ArchRules.in(ApplicationRules.class);

    @ArchTest
    static ArchRules serviceRules = ArchRules.in(ServiceRules.class);

    @ArchTest
    static ArchRules domainRules = ArchRules.in(DomainRules.class);


}
