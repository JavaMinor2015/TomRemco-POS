package e20150907.fiche.domain.concrete.discounts;

import e20150907.fiche.domain.abs.Discount;
import lombok.NoArgsConstructor;

/**
 * Created by alex on 9/8/15.
 */
public class DiscountNone extends Discount{

    public DiscountNone(){
        super(0);
    }

    @Override
    public double getDiscountOn(double price, int amount) {
        return price * amount;
    }

    @Override
    public String toString(){
        return " ";
    }
}
