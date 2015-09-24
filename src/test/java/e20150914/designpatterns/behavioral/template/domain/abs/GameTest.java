package e20150914.designpatterns.behavioral.template.domain.abs;

import e20150914.designpatterns.behavioral.template.domain.concrete.Baseball;
import e20150914.designpatterns.behavioral.template.domain.concrete.Football;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class GameTest extends TestCase {

    @Test
    public void testTemplateMethod(){
        Game football = new Football();
        assertEquals("Setting football\nStarting football\nStopping football\n",football.play());

        Game baseball = new Baseball();
        assertEquals("Setting baseball\nStarting baseball\nStopping baseball\n",baseball.play());
    }
}