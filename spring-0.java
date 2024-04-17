In a Spring Boot application when an API is called, the following sequence of events typically occurs:
1. first reaches the web container (e.g., Tomcat)
2. web container forwards the request to the Dispatcher Servlet, a central component in Spring MVC applications.
3. The Dispatcher Servlet uses Handler Mappings to identify a suitable controller method that can handle the request. This involves matching the request URL pattern to a controller method's @RequestMapping annotation.
    @RequestMapping annotation : mappings between URLs and controller 
4. then Dispatcher Servlet invokes that method, typically located in a folder named controllers 
5.  controller might interact with service layer classes located in the services
6. Services might interact with repository classes, Repositories provide an abstraction layer for interacting with your data source (e.g., database) using JPA, etc

    [Dispatcher --> Controller --> service --> repo --> response] 
    
folders:
1. config:
    Contains configuration classes for various aspects of your application (e.g., database connection, security).
2. api  -- controllers
        -- dto (Data Transfer Objects for transferring data b/w diff layers of ur app +  `loosely coupled` Service and controller layers can work with DTOs without depending on the specific implementation details of your JPA entities.)
  Holds classes responsible for handling incoming HTTP requests and defining your application's API endpoints.
3. models (entities): Contains classes representing your data models (POJOs or domain objects).
4. repositories: This subdirectory stores classes responsible for interacting with your data source (e.g., JPA repositories).
5. services: Contains classes encapsulating your application's business logic and interacting with other components like repositories.
6. utils: This is an optional directory for utility classes that can be reused across your application.


files:
Models.java:..................................................................................................................

@Entity // This annotation marks this class as a JPA entity (maps to a database table)
@Data // This is a Lombok annotation that generates boilerplate code like getters, setters, equals, hashCode, and toString (optional)
public class User {

  @Id // This annotation marks the following field as the primary key for the entity
  @GeneratedValue(strategy = GenerationType.IDENTITY) // This defines how the ID will be generated (automatically in this case)
  private Long id;

  private String name;
  private String email;

  // Getters and setters are automatically generated by @Data (if used)
  // You can also define custom methods here
}

...............................................................................................................................


what is Lombok?
Lombok is a popular Java library that provides a concise way to reduce boilerplate code by using annotations.
It eliminates the need to write repetitive code for getters, setters, equals(), hashCode(), and toString() methods in your Java classes.
Also, Readability++, Utils++ ( logging, builders, and value objects)

@ToString: Generates a toString() method that displays the class name and values of all fields.
@Getter and @Setter: These annotations can be used individually to generate only getters or setters for specific fields.
@Data: This is a comprehensive annotation that generates getters, setters, equals(), hashCode(), and toString() methods for all non-static fields in a class.

..................................................................................................................................
@Autowired annotation in Spring Boot is used for dependency injection,  automatically inject a required dependency (another bean).
This simplifies code by removing the need for manual bean lookup and improves maintainability.


In Spring Boot, a bean is a managed object that forms the backbone of your application. It's any Java object that's instantiated, configured, and managed by the Spring IoC (Inversion of Control) container.

