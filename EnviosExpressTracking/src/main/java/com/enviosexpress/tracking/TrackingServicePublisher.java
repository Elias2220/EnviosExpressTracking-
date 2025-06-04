package com.enviosexpress.tracking;

import jakarta.xml.ws.Endpoint;

public class TrackingServicePublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8080/ws/tracking";
        Endpoint.publish(url, new TrackingServiceImpl());
        System.out.println("Servicio SOAP publicado en " + url + "?wsdl");
    }
}
