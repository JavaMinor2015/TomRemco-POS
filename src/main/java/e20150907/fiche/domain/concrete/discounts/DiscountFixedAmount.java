package e20150907.fiche.domain.concrete.discounts;

import e20150907.fiche.domain.abs.Discount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class DiscountFixedAmount extends Discount {


    public DiscountFixedAmount(double discount) {
        super(discount);
    }

    @Override
    public double getDiscountOn(final double price, int amount) {
        if(super.discountValue > price){
            log.info("Discount is larger than total price!");
        }
        return (price - super.discountValue)*amount;
    }

    @Override
    public String toString(){
        return String.valueOf(super.discountValue) + " each";
    }
}
