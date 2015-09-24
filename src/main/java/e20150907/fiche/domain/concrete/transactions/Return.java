package e20150907.fiche.domain.concrete.transactions;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.abs.Transaction;
import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.repository.ScanItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/10/15.
 */
public class Return extends Transaction{

    // TODO in combination with fidelity card, did customer actually buy? how much did they buy it for?

    private static Logger logger = LogManager.getLogger(Return.class.getName());

    private Basket basket;
    private Bill bill;
    private ScanItemRepository repository;
    private Double totalPrice;

    public Return(){
        basket = new Basket();
        bill = new Bill();
        repository = ScanItemRepository.createInstance();
    }

    @Override
    public boolean handleCode(final String code){
        ScanItem item = repository.getItemByCode(code);
        if(item != null){
            basket.addToBasket(item);
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }

    @Override
    public boolean handlePayment(final PaymentItem item) {
        logger.info("No need to handle customer payment in case of a return.");
        return false;
    }

    @Override
    public void finishTransaction(final boolean print) {
        bill.print();
    }

    @Override
    public void calculate(){
        totalPrice = basket.calculateTotalPrice() * -1;
    }

    @Override
    public void closeTransaction() {
        calculate();
        // TODO properties file
        bill.setDescription("Bill of Return");

        bill.setScanItemsMap(basket.getScannedItems());
        bill.setTotalPrice(totalPrice);
    }
}
