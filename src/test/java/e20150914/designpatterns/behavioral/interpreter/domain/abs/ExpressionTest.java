package e20150914.designpatterns.behavioral.interpreter.domain.abs;

import e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions.AndExpression;
import e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions.NotExpression;
import e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions.OrExpression;
import e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions.Terminal;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class ExpressionTest extends TestCase {

    @Test
    public void testInterpreter(){
        Terminal t1 = new Terminal("Socrates");
        Terminal t2 = new Terminal("Human");

        assertTrue(new OrExpression(t1,t2).validate("Socrates"));
        assertTrue(new OrExpression(t1,t2).validate("Human"));

        Terminal t3 = new Terminal("Socrates");

        assertTrue(new AndExpression(t1,t3).validate("Socrates"));

        assertTrue(new NotExpression(t1).validate("Plato"));

        assertTrue(new AndExpression(new NotExpression(t1),t2).validate("Human"));

        assertTrue(new OrExpression(t1,new NotExpression(t1)).validate("Human"));

    }

}