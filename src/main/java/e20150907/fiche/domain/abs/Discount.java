package e20150907.fiche.domain.abs;

import e20150907.fiche.repository.DiscountRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;

import java.time.LocalDate;

/**
 * Created by alex on 9/7/15.
 */
@NoArgsConstructor
public abstract class Discount extends DomainObject{
    protected static Logger log = LogManager.getLogger(Discount.class.getName());
    @Getter
    private LocalDate date;
    @Getter
    protected String desc;
    @Getter
    protected double discountValue;
    public Discount(double discount){
        super();

        //TODO update when populator will be updated
        date = LocalDate.now();
        self += "/discounts/" + id;
        this.discountValue = discount;
        DiscountRepository.createInstance().addDiscount(this);
        desc = this.toString();
    }
    public abstract double getDiscountOn(final double price, int amount);
}
