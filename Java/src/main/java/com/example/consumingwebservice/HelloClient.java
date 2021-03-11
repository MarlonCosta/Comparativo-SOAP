
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.HelloRequest;
import com.example.consumingwebservice.wsdl.ObjectFactory;
import com.example.consumingwebservice.wsdl.SayHello;
import com.example.consumingwebservice.wsdl.SayHelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class HelloClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(HelloClient.class);

    public JAXBElement<SayHelloResponse> SayHello(String name) {

        ObjectFactory factory = new ObjectFactory();

        HelloRequest request = factory.createHelloRequest();
        SayHello sayHello = factory.createSayHello();
        request.setName(name);
        sayHello.setHelloRequest(request);

        log.info("Nome:  " + name);

        return (JAXBElement<SayHelloResponse>) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.learnwebservices.com/services/hello?WSDL", sayHello);
    }

}
