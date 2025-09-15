# Validation Demo Project

A Spring Boot 2.2.0 project demonstrating **DTO-level validation** in a REST API.  
This project is designed as a learning and reference example for developers to understand **field-level, nested, collection, and class-level validation**, along with **custom validators** and **validation groups**.  

---

## Features

- **Field-level validation**: `@NotBlank`, `@Size`, `@Pattern`, `@Email`, `@Min`, `@Max`, `@Past`, etc.
- **Nested DTO validation**: Use `@Valid` for nested objects like `OwnerDTO` or `EngineDTO`.
- **Collection validation**: Validate lists of objects with `@Valid` and `@Size(min=...)`.
- **Class-level validation**: Cross-field validation example (`DateRangeDTO`) ensures `startDate <= endDate`.
- **Custom validators**: Example: `@ValidDateRange`.
- **Validation groups**: Different rules for create vs update operations.
- **Global exception handling**: Returns structured and user-friendly JSON error responses for invalid DTOs.
- **Path and request parameter validation**: `@PathVariable` and `@RequestParam` validation with `@Validated`.
- **Programmatic validation**: Using `Validator` in service layer for dynamic validations.
- **Validation constants endpoint**: Returns constants like max lengths and regex patterns for frontend validation.

---

## Project Structure

src/main/java/com/example/validationdemo/
├─ controller/ # REST controllers
├─ dto/ # DTOs with validation annotations
├─ validation/ # Custom validators and validation groups
├─ exception/ # Global exception handler
└─ ValidationDemoApplication.java

## Prerequisites

- **Java 11**  
- **Maven 2.2.0.RELEASE**  
- IDE: IntelliJ, Eclipse, VS Code, etc.  
- (Optional) Postman or curl for testing APIs  