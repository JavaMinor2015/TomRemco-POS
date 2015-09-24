package e20150907.fiche.domain.concrete.paymentitems;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.util.NumUtil;
import lombok.Getter;

/**
 * Created by alex on 9/10/15.
 */
public class Digital extends PaymentItem {
    @Getter
    public String digitcode;

    @Getter
    public double digitalAmount;

    public Digital(final double amount, final String digitcode){
        super(null,amount);
        this.digitcode = digitcode;
        this.digitalAmount = NumUtil.getRandomDouble(1000);
    }

    @Override
    public double remainder(final double price) {
        if(getAmount()==-1){
            return 0;
        }
        return price-getAmount();
    }

    @Override
    public boolean isValid(double price) {
        if(digitcode.length() == 4 && digitalAmount <= price)
            return true;
        return false;
    }
}
