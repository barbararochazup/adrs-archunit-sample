package br.com.rossalli.noroeste.java.sample.contact.architecture.utils;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;

import java.util.Set;

public class ArchConditionCustom {

    private static final int PUBLIC_METHODS_LIMIT = 1;

    public static ArchCondition<JavaClass> containspecificmethod(String methodName) {

        return new ArchCondition<>("Contains a specifc method") {

            @Override
            public void check(final JavaClass clazz, final ConditionEvents events) {

                final String name = clazz.getName();
                final Set<JavaMethod> methodsSet = clazz.getMethods();
                boolean hasMethod = Boolean.FALSE;

                for (final JavaMethod javaMethod : methodsSet) {
                    if (javaMethod.getName().equals(methodName)) {
                        hasMethod = Boolean.TRUE;
                    }
                }

                if (!hasMethod) {
                    throw new AssertionError(String.format("Class %s not contains %s method",
                            name, methodName));
                }
            }
        };
    }


    public static ArchCondition<JavaClass> injectOnlyType(String typeName) {

        return new ArchCondition<>(String.format("Inject only %s class", typeName)) {

            @Override
            public void check(final JavaClass clazz, final ConditionEvents events) {

                final String name = clazz.getName();
                final Set<JavaField> fieldsSet = clazz.getFields();
                boolean otherTypeInjection = Boolean.FALSE;

                for (final JavaField javaField : fieldsSet) {
                    if (!javaField.getName().contains(typeName)) {
                        otherTypeInjection = Boolean.TRUE;
                    }
                }

                if (otherTypeInjection) {
                    throw new AssertionError(String.format("Class %s not contains only %s injection",
                            name, typeName));
                }
            }
        };
    }

    public static ArchCondition<JavaClass> containOnlyOnePublicMethod() {

        return new ArchCondition<>("Only one public method") {

            @Override
            public void check(final JavaClass clazz, final ConditionEvents events) {

                final String name = clazz.getName();
                final Set<JavaMethod> methodsSet = clazz.getMethods();
                int PublicMethodsCount = 0;

                for (final JavaMethod javaMethod : methodsSet) {
                    if (javaMethod.getModifiers()
                            .contains(JavaModifier.PUBLIC)) {
                        PublicMethodsCount = PublicMethodsCount + 1;
                    }
                }

                if (PublicMethodsCount > PUBLIC_METHODS_LIMIT) {
                    throw new AssertionError(String.format("Class %s contains %d public methods, when limit is %d",
                            name, PublicMethodsCount, PUBLIC_METHODS_LIMIT));
                }
            }
        };
    }

}
