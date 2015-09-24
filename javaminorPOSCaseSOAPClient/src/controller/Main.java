package controller;

/**
 * Created by Tom on 24-9-2015.
 */
public class Main {
    public static void main(String[] args) {
        PaymentServiceImplService service = new PaymentServiceImplService();
        PaymentServiceImpl port = service.getPaymentServiceImplPort();
        port.isValid(new Cash(10), 100);
    }
}
