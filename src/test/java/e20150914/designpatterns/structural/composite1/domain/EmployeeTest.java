package e20150914.designpatterns.structural.composite1.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 9/14/15.
 */
public class EmployeeTest {

    @Test
    public void testComposite1(){
        Employee boss = new Employee("I.M. Theboss",50000);
        Employee subordinate = new Employee("I.M. Not",25000);
        subordinate.addSubordinate(new Employee("M.E. Neither",15000));
        boss.addSubordinate(subordinate);

        // boss has one direct subordinate
        assertEquals(1,boss.getSubordinates().size());

        // boss has two subordinates in total
        assertEquals(2,boss.getNestedSubordinates());

        // boss worth is 50000 + 25000 + 15000
        assertEquals(90000,boss.calculateSubordinateWorth());

        // subordinate worth is 25000 + 15000
        assertEquals(40000,subordinate.calculateSubordinateWorth());
    }


}