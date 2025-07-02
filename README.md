# FMZ CQRS Micronaut

The `fmz-cqrs-micronaut` library provides seamless integration of the CQRS (Command Query Responsibility Segregation) pattern with Micronaut applications.

> **Note:**  
> This version is published as **unstable** because, despite no related code changes, one bean (`Dispatcher`) stopped appearing in tests. This is likely a problem with the test configuration, not the production code.

## Features

- Automatic registration of a Dispatcher supporting CommandHandler and QueryHandler
- Support for logging and transactional interceptors (Micronaut Transactional)
- Simple integration with Micronaut applications

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
  <groupId>com.filipmikolajzeglen.cqrs</groupId>
  <artifactId>fmz-cqrs-micronaut</artifactId>
  <version>1.0.0-UNSTABLE</version>
</dependency>
```

## Quick Start

1. Annotate your main application class or configuration class with `@EnableCqrs`:

```java
@MicronautApplication
@EnableCqrs
public class MyApplication {
    public static void main(String[] args) {
        Micronaut.run(MyApplication.class, args);
    }
}
```

2. Create your own CommandHandlers and QueryHandlers by implementing the appropriate interfaces from `fmz-cqrs-core`.

## Documentation

- **@EnableCqrs** – annotation enabling CQRS integration in a Micronaut application.
- **MicronautDispatcherConfiguration** – configuration registering the Dispatcher and interceptors.
- **MicronautTransactionalCommandInterceptor** – transactional support for commands.
- **MicronautTransactionalQueryInterceptor** – transactional (read-only) support for queries.