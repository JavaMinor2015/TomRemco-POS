package e20150907.fiche.domain.concrete.scanitems;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.util.PreferenceUtil;
import e20150907.fiche.util.StrUtil;
import e20150907.fiche.util.UrlUtil;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class Product extends ScanItem {
    private double price;

    public Product() {
        super();
        self += "/products/" + id.toString();
    }
    /**
     * Easy retrieval method for price.
     *
     * @return product price, including discounts etc.
     * @param amount
     */
    public double getPrice(final int amount){
        return getDiscount().getDiscountOn(price,amount);
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(getName());
        if(hasProperty(PreferenceUtil.getCATEGORY_KEY_NAME())){
            b.append(" (" + getProperty(PreferenceUtil.getCATEGORY_KEY_NAME()) + ")");
        }
        b.append(" @ ");
        b.append(StrUtil.twoDecimal(price));

        if(hasDiscount()){
            b.append("\n");
            b.append("Discount: ");
            b.append(getDiscount().toString());
            b.append(" New price: ");
            b.append(StrUtil.twoDecimal(getDiscount().getDiscountOn(getPrice(),1)));
        }

        return b.toString();
    }

    public void replace(Product product){
        setDiscount(product.getDiscount());
        price = product.price;
    }
}
