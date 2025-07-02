package com.filipmikolajzeglen.cqrs.micronaut;

import com.filipmikolajzeglen.cqrs.persistence.database.DatabaseCommandHandler;
import com.filipmikolajzeglen.cqrs.persistence.database.DatabaseQueryHandler;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

/**
 * Micronaut factory for registering CQRS persistence handlers as singleton beans.
 * <p>
 * Registers {@link DatabaseCommandHandler} and {@link DatabaseQueryHandler} using the application's {@link EntityManager}.
 * These beans allow the CQRS dispatcher to handle persistence commands and queries.
 */
@Factory
public class MicronautPersistenceModuleConfiguration
{
    /**
     * Registers a {@link DatabaseQueryHandler} singleton for handling database queries.
     *
     * @param entityManager the JPA entity manager
     * @return a new {@link DatabaseQueryHandler} instance
     */
    @Singleton
    public DatabaseQueryHandler<?> databaseQueryHandler(EntityManager entityManager)
    {
        return new DatabaseQueryHandler<>(entityManager);
    }

    /**
     * Registers a {@link DatabaseCommandHandler} singleton for handling database commands.
     *
     * @param entityManager the JPA entity manager
     * @return a new {@link DatabaseCommandHandler} instance
     */
    @Singleton
    public DatabaseCommandHandler<?> databaseCommandHandler(EntityManager entityManager)
    {
        return new DatabaseCommandHandler<>(entityManager);
    }
}
