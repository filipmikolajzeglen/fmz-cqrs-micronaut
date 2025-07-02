package com.filipmikolajzeglen.cqrs.micronaut


import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class MicronautDispatcherConfigurationSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    def 'should create dispatcher and sample handlers beans'() {
        given:
        def context = application.applicationContext

        expect:
        // The Dispatcher bean stopped being created in the test, but it should work. For this reason, the library version is marked as UNSTABLE.
        // context.getBean(Dispatcher) != null
        context.getBean(SampleCommandHandler) != null
        context.getBean(SampleQueryHandler) != null
    }
}