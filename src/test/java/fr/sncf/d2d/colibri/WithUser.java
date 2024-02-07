package fr.sncf.d2d.colibri;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.core.annotation.AliasFor;
import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserSecurityContextFactory.class)
public @interface WithUser {

    String value() default "";

    @AliasFor("value")
    String username() default "";
}
