package e20150907.fiche.api.soap.service;

import e20150907.fiche.domain.abs.PaymentItem;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Tom on 24-9-2015.
 */
@WebService
public interface PaymentService {
    @WebMethod
    public boolean isValid(PaymentItem paymentItem, double price);
}
