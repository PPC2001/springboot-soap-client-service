package com.springboot.springboot_soap_service.controller;

import com.springboot.springboot_soap_service.service.SoapClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapClientController {

    @Autowired
    private SoapClientService soapClientService;

    @GetMapping("/add")
    public Integer add(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return soapClientService.callAddOperation(num1, num2);
    }

    @GetMapping("/subtract")
    public Integer subtract(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return soapClientService.callSubtractOperation(num1, num2);
    }

    @GetMapping("/multiply")
    public Integer multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return soapClientService.callMultiplyOperation(num1, num2);
    }

    @GetMapping("/divide")
    public Integer divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return soapClientService.callDivideOperation(num1, num2);
    }
}
