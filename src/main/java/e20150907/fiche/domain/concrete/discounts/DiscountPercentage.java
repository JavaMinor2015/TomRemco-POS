package e20150907.fiche.domain.concrete.discounts;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.util.StrUtil;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alex on 9/7/15.
 */
@XmlRootElement
@NoArgsConstructor
public class DiscountPercentage extends Discount {

    public DiscountPercentage(final long discount) {
        super(discount);
        if(discount > 100){
            log.info("Discount is more than 100%!");
        }
    }

    @Override
    public double getDiscountOn(final double price, int amount) {
        return (price * amount) * ((100-discountValue)/100);
    }


    @Override
    public String toString(){
        return StrUtil.twoDecimal(super.discountValue) + "% ";
    }
}
