package controller;

import e20150907.fiche.domain.abs.PaymentItem;

/**
 * Created by alex on 9/9/15.
 */
public class TypeCoupon extends PaymentItem {

    public TypeCoupon(final String type, final double amount){
        super(type,amount);
    }

    @Override
    public double remainder(final double price) {

        // if bigger
        if(price > getAmount()){
            return price - getAmount();
        }
        // if smaller
        return 0;
    }

    @Override
    public boolean isValid(double price) {
        return true;
    }
}
