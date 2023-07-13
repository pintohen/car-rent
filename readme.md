# Rent a Car Project #

> Note: This was an example project just to have a better understanding on how to use the Spring boot framework.
> This does not equate to any real world application and is not intended to be used as such.


## 1. Layers ##

### 1.1. Entities ###

- Car
- Car Group

> These entities were programmed using DDD (Domain Driven Design), which means that they contain Value Objects and relationships between them (many to one, one to many in this example).
> You can find them at the `com.example.carrent.domain` package.


### 1.2. Repositories ###

- CarRepository
- CarGroupRepository

> These repositories are used to access the database and perform CRUD operations on the entities.
> Using this abstraction, we can easily change the database implementation without having to change the code that uses it.
> You can find them at the `com.example.carrent.repository` package.

### 1.3. Services ###

- CarService
- CarGroupService

> These services are used to perform business logic on the entities.
> You can find them at the `com.example.carrent.service` package.

### 1.4. Controllers ###

- CarController
- CarGroupController

> These controllers are used to expose the services to the outside world.
> They serve as Web API endpoints, to be used by the frontend (normally a web application).

### 1.5. DTOs ###

- CarDTO
- CarGroupDTO

> These DTOs (Data Transfer Objects) are used to transfer data between the frontend and the backend.
> They are used to avoid exposing the entities directly to the outside world, which could lead to security issues.
> You can find them at the `com.example.carrent.dto` package.

### 1.6. Mappers ###

- CarMapper
- CarGroupMapper

> These mappers are used to map the DTOs to the entities and vice-versa.
> Using the Indirection GRASP pattern, we can easily change the mapping implementation without having to change the code that uses it(does not produce a functional dependency).
> You can find them at the `com.example.carrent.dto.mapper` package.


## 2. Database ##

### 2.1. config ###

```yaml
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/prod
spring.datasource.username=app
spring.datasource.password=car_rent
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
```

> This is the database configuration file.
> It is used to configure the database connection and the database schema generation.
> We are using MySQL as the database engine, but we could easily change it to another one, without having to change the code that uses it.
> You can find it at the `src/main/resources/application.properties` file.

### 2.2. config test ###

```yaml
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=app
spring.datasource.password=car_rent
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
```

> This is the database configuration file for the tests.
> If the JPA spring repositories weren't used, we could use an in-memory database, like H2, to perform the tests.
> You can find it at the `src/test/resources/application.properties` file.