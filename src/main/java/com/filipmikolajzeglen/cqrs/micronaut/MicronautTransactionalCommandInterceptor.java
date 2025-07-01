package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.core.Command;
import com.filipmikolajzeglen.cqrs.core.CommandInvocation;
import com.filipmikolajzeglen.cqrs.core.TransactionalCommandInterceptor;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

@Singleton
public class MicronautTransactionalCommandInterceptor extends TransactionalCommandInterceptor
{
   @Override
   @Transactional
   public <TYPE> TYPE intercept(Command<TYPE> command, CommandInvocation<TYPE> next)
   {
      return super.intercept(command, next);
   }
}