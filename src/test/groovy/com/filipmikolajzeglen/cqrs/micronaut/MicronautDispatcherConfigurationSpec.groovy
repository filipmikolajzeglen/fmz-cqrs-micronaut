package com.filipmikolajzeglen.cqrs.micronaut

import com.filipmikolajzeglen.cqrs.core.Dispatcher
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
        context.getBean(Dispatcher) != null
        context.getBean(SampleCommandHandler) != null
        context.getBean(SampleQueryHandler) != null
    }
}