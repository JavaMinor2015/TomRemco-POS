package e20150907.fiche.domain.concrete.criteria.specific;

import e20150907.fiche.domain.abs.Criteria;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.criteria.NotCriteria;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import e20150907.fiche.domain.concrete.scanitems.Product;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/16/15.
 */
public class PropertyTypeCriteriaTest extends TestCase {

    @Test
    public void testNoPropertyTypeCriteriaTest(){
        Product p1 = new Product();
        p1.setName("Product1");
        p1.addProperties("type", "ECO");
        p1.addProperties("mycustomproperty","woot");
        p1.addCode("barcode", "1234");
        p1.setDiscount(new DiscountNone());
        p1.setPrice(15.0);
        ScanItem i = p1;

        Product p2 = new Product();
        p2.setName("Product2");
        p2.addProperties("type", "MEAL");
        p2.addCode("barcode", "12345");
        p2.setDiscount(new DiscountNone());
        p2.setPrice(15.0);
        ScanItem i2 = p2;

        Product p3 = new Product();
        p3.setName("Product3");
        p3.addCode("barcode", "123456");
        p3.setDiscount(new DiscountNone());
        p3.setPrice(15.0);
        ScanItem i3 = p3;

        List<ScanItem> list = new ArrayList<>();
        list.add(i);
        list.add(i2);
        list.add(i3);

        Criteria propertyType = new PropertyTypeCriteria("type");
        assertEquals(2, propertyType.meetCriteria(list).size());

        propertyType = new PropertyTypeCriteria("mycustomproperty");
        assertEquals(1, propertyType.meetCriteria(list).size());

        Criteria noPropertyType = new NotCriteria(new PropertyTypeCriteria("mycustomproperty"));
        assertEquals(2, noPropertyType.meetCriteria(list).size());

    }

}