package e20150907.fiche.domain.concrete.scanitems;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.util.UrlUtil;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/8/15.
 */
@Getter
@Setter
public class FidelityCard extends ScanItem{
    private String code;
    private Customer customer;
    private Map<DateTime, Map<Product,Integer>> productHistory;

    public FidelityCard(){
        super();
        productHistory = new HashMap<>();
        self += "/cards/"  + id.toString();
    }

    public void addProductsToHistory(DateTime purchaseDate,Map<Product,Integer> productMap){
        productHistory.put(purchaseDate, productMap);
    }

    public boolean codeMatches(final String codeToCheck){
        if(code.equals(codeToCheck)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(getName());

        if(hasDiscount()){
            b.append("\n");
            b.append("Discount: ");
            b.append(getDiscount().toString());
        }

        return b.toString();
    }
}
