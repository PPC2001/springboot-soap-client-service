
# Spring Boot SOAP Client Service

This project demonstrates how to consume a SOAP web service using Spring Boot. It supports multiple arithmetic operations like Add, Subtract, Multiply, and Divide using the calculator web service from `http://www.dneonline.com/calculator.asmx`.

## Features

- SOAP client using Spring Web Services
- Supports the following operations:
  - Add
  - Subtract
  - Multiply
  - Divide
- Configurable SOAP endpoint and actions through properties and enums.
- Logging using SLF4J.
  
## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Web Services
- JAXB for XML binding
- Lombok for reducing boilerplate code

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/springboot-soap-client-service.git
   ```

2. Navigate to the project directory:
   ```bash
   cd springboot-soap-client-service
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. The application will be accessible on `http://localhost:8080`.

## API Endpoints

### Add Operation

- **URL:** `/add`
- **Method:** `GET`
- **Parameters:** 
  - `num1` (Integer)
  - `num2` (Integer)
- **Example:**
  - `http://localhost:8080/add?num1=10&num2=5`
  
### Subtract Operation

- **URL:** `/subtract`
- **Method:** `GET`
- **Parameters:** 
  - `num1` (Integer)
  - `num2` (Integer)
- **Example:**
  - `http://localhost:8080/subtract?num1=10&num2=5`

### Multiply Operation

- **URL:** `/multiply`
- **Method:** `GET`
- **Parameters:** 
  - `num1` (Integer)
  - `num2` (Integer)
- **Example:**
  - `http://localhost:8080/multiply?num1=10&num2=5`

### Divide Operation

- **URL:** `/divide`
- **Method:** `GET`
- **Parameters:** 
  - `num1` (Integer)
  - `num2` (Integer)
- **Example:**
  - `http://localhost:8080/divide?num1=10&num2=5`

## Configuration

The SOAP endpoint URL and actions are configured in the `application.properties` and `SoapAction` enum.

### application.properties

```properties
soap.endpoint=http://www.dneonline.com/calculator.asmx
```

### SoapAction Enum

The `SoapAction` enum contains the SOAP actions for the various operations (`ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`).

## Contributing

Feel free to fork the repository, create a new branch, and submit pull requests.
