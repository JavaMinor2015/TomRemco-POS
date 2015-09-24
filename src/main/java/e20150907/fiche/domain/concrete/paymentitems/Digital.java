package e20150907.fiche.domain.concrete.paymentitems;

import e20150907.fiche.domain.abs.PaymentItem;

/**
 * Created by alex on 9/10/15.
 */
public class Digital extends PaymentItem {

    public Digital(final double amount){
        super(null,amount);
    }

    @Override
    public double remainder(final double price) {
        if(getAmount()==-1){
            return 0;
        }
        return price-getAmount();
    }
}
