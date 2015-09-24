package controller;

/**
 * Created by alex on 9/10/15.
 */
public class Cash extends PaymentItem {
    public Cash(final double amount){
        super(null,amount);
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
        return true;
    }


}
