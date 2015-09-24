package e20150907.fiche.api.soap;

import e20150907.fiche.api.soap.service.PaymentService;
import e20150907.fiche.api.soap.service.impl.PaymentServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Tom on 24-9-2015.
 */
public class SoapMain {

    public static void main(String[] args) {
        PaymentService implementor = new PaymentServiceImpl();
        String address = "http://localhost:8090/Payment";
        Endpoint.publish(address, implementor);
    }
}
