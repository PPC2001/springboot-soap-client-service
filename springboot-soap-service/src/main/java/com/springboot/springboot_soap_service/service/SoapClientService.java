package com.springboot.springboot_soap_service.service;

import com.example.soap.generated.calculator.*;
import com.springboot.springboot_soap_service.util.SoapAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
@Service
public class SoapClientService {

    // Inject the SOAP endpoint URL from the application properties file
    @Value("${soap.endpoint}")
    private String soapEndpoint;

    // Autowired WebServiceTemplate for handling SOAP requests
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * This method sends a SOAP request for the Add operation.
     *
     * @param num1 First number
     * @param num2 Second number
     * @return The result of the addition
     */
    public Integer callAddOperation(Integer num1, Integer num2) {
        log.info("Sending SOAP request for Add operation: {} + {}", num1, num2);

        // Create the request object (Add request) with the input parameters
        Add request = new Add();
        request.setIntA(num1);
        request.setIntB(num2);

        // Send the request and receive the response
        AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(
                soapEndpoint, // SOAP service endpoint
                request,      // Request object
                new SoapActionCallback(SoapAction.ADD.getUrl()) // SOAP Action for Add operation
        );

        // Return the result from the response
        return response.getAddResult();
    }

    /**
     * This method sends a SOAP request for the Subtract operation.
     *
     * @param num1 First number
     * @param num2 Second number
     * @return The result of the subtraction
     */
    public Integer callSubtractOperation(Integer num1, Integer num2) {
        log.info("Sending SOAP request for Subtract operation: {} - {}", num1, num2);

        // Create the request object (Subtract request) with the input parameters
        Subtract request = new Subtract();
        request.setIntA(num1);
        request.setIntB(num2);

        // Send the request and receive the response
        SubtractResponse response = (SubtractResponse) webServiceTemplate.marshalSendAndReceive(
                soapEndpoint, // SOAP service endpoint
                request,      // Request object
                new SoapActionCallback(SoapAction.SUBTRACT.getUrl()) // SOAP Action for Subtract operation
        );

        // Return the result from the response
        return response.getSubtractResult();
    }

    /**
     * This method sends a SOAP request for the Multiply operation.
     *
     * @param num1 First number
     * @param num2 Second number
     * @return The result of the multiplication
     */
    public Integer callMultiplyOperation(Integer num1, Integer num2) {
        log.info("Sending SOAP request for Multiply operation: {} * {}", num1, num2);

        // Create the request object (Multiply request) with the input parameters
        Multiply request = new Multiply();
        request.setIntA(num1);
        request.setIntB(num2);

        // Send the request and receive the response
        MultiplyResponse response = (MultiplyResponse) webServiceTemplate.marshalSendAndReceive(
                soapEndpoint, // SOAP service endpoint
                request,      // Request object
                new SoapActionCallback(SoapAction.MULTIPLY.getUrl()) // SOAP Action for Multiply operation
        );

        // Return the result from the response
        return response.getMultiplyResult();
    }

    /**
     * This method sends a SOAP request for the Divide operation.
     *
     * @param num1 First number
     * @param num2 Second number
     * @return The result of the division
     */
    public Integer callDivideOperation(Integer num1, Integer num2) {
        log.info("Sending SOAP request for Divide operation: {} / {}", num1, num2);

        // Create the request object (Divide request) with the input parameters
        Divide request = new Divide();
        request.setIntA(num1);
        request.setIntB(num2);

        // Send the request and receive the response
        DivideResponse response = (DivideResponse) webServiceTemplate.marshalSendAndReceive(
                soapEndpoint, // SOAP service endpoint
                request,      // Request object
                new SoapActionCallback(SoapAction.DIVIDE.getUrl()) // SOAP Action for Divide operation
        );

        // Return the result from the response
        return response.getDivideResult();
    }
}
