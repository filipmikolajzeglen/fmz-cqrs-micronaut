package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.core.Pagination;
import com.filipmikolajzeglen.cqrs.core.QueryHandler;
import jakarta.inject.Singleton;

@Singleton
class SampleQueryHandler implements QueryHandler<SampleQuery, String>
{
   @Override
   public <PAGE> PAGE handle(SampleQuery query, Pagination<String, PAGE> pagination)
   {
      return pagination.expandSingle("Result for: " + query.input);
   }
}