package e20150914.designpatterns.behavioral.strategy.logic;

import e20150914.designpatterns.behavioral.strategy.domain.concrete.AdditionStrategy;
import e20150914.designpatterns.behavioral.strategy.domain.concrete.MultiplicationStrategy;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class CalculatorTest extends TestCase {

    @Test
    public void testStrategy() {
        Calculator calculator = new Calculator();
        calculator.setStrategy(new AdditionStrategy());
        assertEquals(5, calculator.calculate(2, 3));
        calculator.setStrategy(new MultiplicationStrategy());
        assertEquals(6, calculator.calculate(2, 3));
    }

}