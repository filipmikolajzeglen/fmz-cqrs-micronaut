package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.core.CommandHandler;
import jakarta.inject.Singleton;

@Singleton
class SampleCommandHandler implements CommandHandler<SampleCommand, String>
{
   @Override
   public String handle(SampleCommand command)
   {
      return "Handled command: " + command.input;
   }
}