package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.core.Query;

class SampleQuery extends Query<String>
{
   public final String input;

   public SampleQuery(String input)
   {
      this.input = input;
   }
}