package e20150907.fiche.repository;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.logic.ProductFactory;
import e20150907.fiche.util.Populator;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Windows 7 on 23-9-2015.
 */
public class DiscountRepository {
    private static Logger logger = LogManager.getLogger(DiscountRepository.class.getName());
    @Getter
    private List<Discount> discounts;
    private static DiscountRepository instance;

    private DiscountRepository(){
        Populator populator = ProductFactory.getPopulator();
        discounts = populator.getDiscountList();
    }

    public Discount getDiscountByID(UUID id){
        for(Discount d : discounts){
            if(d.getId().equals(id)){
                return d;
            }
        }

        return null;
    }

    public void addDiscount(Discount discount){
        discounts.add(discount);
    }

    public void removeDiscount(Discount discount){
        discounts.remove(discount);
    }

    public static DiscountRepository createInstance(){
        if(instance == null)
            synchronized (DiscountRepository.class) {
                if (instance == null)
                    instance = new DiscountRepository();
            }
        return instance;
    }

    public List<Discount> getDiscountsOfToday(){
        LocalDate date = LocalDate.now();
        List<Discount> discounts = new ArrayList<>();

        for(Discount d : this.discounts){
            if(d.getDate().equals(date)){
                discounts.add(d);
            }
        }

        return discounts;
    }


}
