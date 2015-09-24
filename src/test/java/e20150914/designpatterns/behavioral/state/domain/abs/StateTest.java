package e20150914.designpatterns.behavioral.state.domain.abs;

import e20150914.designpatterns.behavioral.state.domain.concrete.Context;
import e20150914.designpatterns.behavioral.state.domain.concrete.StartState;
import e20150914.designpatterns.behavioral.state.domain.concrete.StopState;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class StateTest extends TestCase {

    @Test
    public void testState(){
        Context context = new Context();

        new StartState().doAction(context);
        assertEquals("Start state",context.getState().toString());

        new StopState().doAction(context);
        assertEquals("Stop state",context.getState().toString());

        new StartState().doAction(context);
        assertEquals("Start state",context.getState().toString());

    }

}