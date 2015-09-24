package e20150914.designpatterns.behavioral.command2.logic;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/16/15.
 */
public class CalculatorUserTest extends TestCase {


    @Test
    public void testCalculatorCommand(){
        CalculatorUser user = new CalculatorUser();

        user.calculate('+', 5); // result = 5
        assertEquals(5.0, user.getCalculator().getCalculatorState(), 0.001);

        user.calculate('*', 2); // result = 10
        assertEquals(10.0, user.getCalculator().getCalculatorState(), 0.001);

        user.undo(1); // result = 5
        assertEquals(5.0, user.getCalculator().getCalculatorState(), 0.001);

        user.redo(1); // result = 10
        assertEquals(10.0, user.getCalculator().getCalculatorState(), 0.001);

        user.calculate('/', 5); // result = 2
        assertEquals(2.0, user.getCalculator().getCalculatorState(), 0.001);

        user.calculate('-', 1); // result = 1
        assertEquals(1.0, user.getCalculator().getCalculatorState(),0.001);

        user.undo(2); // result = 10
        assertEquals(10.0, user.getCalculator().getCalculatorState(),0.001);

        user.redo(1); // result = 2
        assertEquals(2.0, user.getCalculator().getCalculatorState(),0.001);

    }
}