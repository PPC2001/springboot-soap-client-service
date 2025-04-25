
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

## Setup and Configuration

### 1. **SOAP Client Configuration**

The SOAP client is configured in the `SoapClientConfig.java` class. The `Jaxb2Marshaller` is used to marshal and unmarshal XML objects to and from Java objects. We use a `WebServiceTemplate` to send SOAP requests.

```java
@Bean
public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("com.example.soap.generated.calculator");
    return marshaller;
}

@Bean
public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
    webServiceTemplate.setMarshaller(marshaller);
    webServiceTemplate.setUnmarshaller(marshaller);
    webServiceTemplate.setDefaultUri(soapEndpoint);
    return webServiceTemplate;
}
```

### 2. **Class Generation from WSDL**

The Java classes for interacting with the SOAP service are generated automatically from the WSDL file of the SOAP service using Maven's `jaxws-maven-plugin`. The `pom.xml` is configured to download the WSDL and generate the appropriate Java classes.

**Configuration in `pom.xml`:**
```xml
<plugin>
    <groupId>com.sun.xml.ws</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>4.0.0</version>
    <executions>
        <execution>
            <id>wsimport-calculator</id>
            <goals>
                <goal>wsimport</goal>
            </goals>
            <configuration>
                <wsdlUrls>
                    <wsdlUrl>http://www.dneonline.com/calculator.asmx?wsdl</wsdlUrl>
                </wsdlUrls>
                <packageName>com.example.soap.generated.calculator</packageName>
                <sourceDestDir>${project.build.directory}/generated-sources/wsdl/calculator</sourceDestDir>
                <keep>true</keep>
            </configuration>
        </execution>
    </executions>
</plugin>
```

This configuration downloads the WSDL from `http://www.dneonline.com/calculator.asmx?wsdl` and generates Java classes in the package `com.example.soap.generated.calculator`.

### 3. **SOAP Operations**

- **Add Operation**: Sends a request to the SOAP service to add two numbers.
- **Subtract Operation**: Sends a request to subtract two numbers.
- **Multiply Operation**: Sends a request to multiply two numbers.
- **Divide Operation**: Sends a request to divide two numbers.

These operations are performed by calling respective methods in the `SoapClientService` class. Each method marshals a request object, sends it to the SOAP service, and unmarshals the response.

```java
public Integer callAddOperation(Integer num1, Integer num2) {
    Add request = new Add();
    request.setIntA(num1);
    request.setIntB(num2);
    AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(
            soapEndpoint,
            request,
            new SoapActionCallback(SoapAction.ADD.getUrl())
    );
    return response.getAddResult();
}
```


## Running the Application

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
