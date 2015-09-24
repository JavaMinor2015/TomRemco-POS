package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.scanitems.Customer;
import e20150907.fiche.domain.concrete.scanitems.Product;
import e20150907.fiche.util.Populator;

import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
public class ProductFactory {
    private static List<Product> productList;
    private static List<Customer> customerList;
    private static Populator populator;

    public static List<Product> getProductList(){
        return productList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static Populator getPopulator() {
        if(populator == null){
            populator = new Populator();
            populator.populate();
        }

        return populator;
    }
}
