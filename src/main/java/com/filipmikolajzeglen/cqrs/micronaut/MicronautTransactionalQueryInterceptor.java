package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.core.Pagination;
import com.filipmikolajzeglen.cqrs.core.Query;
import com.filipmikolajzeglen.cqrs.core.QueryInvocation;
import com.filipmikolajzeglen.cqrs.core.TransactionalQueryInterceptor;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

@Singleton
public class MicronautTransactionalQueryInterceptor extends TransactionalQueryInterceptor
{
   @Override
   @Transactional(readOnly = true)
   public <TYPE, PAGE> PAGE intercept(Query<TYPE> query, Pagination<TYPE, PAGE> pagination,
         QueryInvocation<TYPE, PAGE> next)
   {
      return super.intercept(query, pagination, next);
   }
}