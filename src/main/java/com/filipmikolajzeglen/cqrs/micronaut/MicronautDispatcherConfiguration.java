package com.filipmikolajzeglen.cqrs.micronaut;

import java.util.List;

import com.filipmikolajzeglen.cqrs.core.CommandHandler;
import com.filipmikolajzeglen.cqrs.core.Dispatcher;
import com.filipmikolajzeglen.cqrs.core.DispatcherDecorator;
import com.filipmikolajzeglen.cqrs.core.DispatcherRegistry;
import com.filipmikolajzeglen.cqrs.core.LoggingCommandInterceptor;
import com.filipmikolajzeglen.cqrs.core.LoggingQueryInterceptor;
import com.filipmikolajzeglen.cqrs.core.QueryHandler;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Factory
public class MicronautDispatcherConfiguration
{
   @Singleton
   public Dispatcher dispatcher(
         List<CommandHandler<?, ?>> commandHandlers,
         List<QueryHandler<?, ?>> queryHandlers
   )
   {
      log.info("Creating Dispatcher with: {} command handlers and {} query handlers", commandHandlers.size(),
            queryHandlers.size());

      return new DispatcherDecorator(
            new DispatcherRegistry(commandHandlers, queryHandlers),
            List.of(
                  new LoggingCommandInterceptor(),
                  new MicronautTransactionalCommandInterceptor()
            ),
            List.of(
                  new LoggingQueryInterceptor(),
                  new MicronautTransactionalQueryInterceptor()
            )
      );
   }
}