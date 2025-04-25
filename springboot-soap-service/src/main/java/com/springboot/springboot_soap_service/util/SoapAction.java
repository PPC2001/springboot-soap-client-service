package com.springboot.springboot_soap_service.util;

import lombok.Getter;

@Getter
public enum SoapAction {

    ADD("http://tempuri.org/Add"),
    SUBTRACT("http://tempuri.org/Subtract"),
    MULTIPLY("http://tempuri.org/Multiply"),
    DIVIDE("http://tempuri.org/Divide");

    private final String url;

    SoapAction(String url) {
        this.url = url;
    }
}
