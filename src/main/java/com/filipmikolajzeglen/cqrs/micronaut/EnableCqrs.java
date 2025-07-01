package com.filipmikolajzeglen.cqrs.micronaut;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.micronaut.context.annotation.Import;

/**
 * Annotation that enables FMZ CQRS integration with a Micronaut application.
 * Use it on your configuration or main application class to automatically import CQRS configuration.
 *
 * Example usage:
 * <pre>
 * &#64;MicronautApplication
 * &#64;EnableCqrs
 * public class MyApp { ... }
 * </pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(classes = MicronautDispatcherConfiguration.class)
public @interface EnableCqrs
{
}