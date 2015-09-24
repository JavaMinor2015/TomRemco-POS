package e20150914.designpatterns.behavioral.memento.logic;

import e20150914.designpatterns.behavioral.memento.domain.Original;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class MementoManagerTest extends TestCase {

    @Test
    public void testMemento() {
        Original original1 = new Original();
        Original original2 = new Original();
        Original original3 = new Original();

        MementoManager manager = new MementoManager();
        manager.addOriginal(original1);
        manager.addOriginal(original2);
        manager.addOriginal(original3);


        original1.setState("state 1");
        manager.save(original1); // "state 1" saved as memento 0 for original1
        assertEquals("state 1", manager.load(original1, 0).getState());

        original2.setState("state 1");
        original3.setState("state 5");
        manager.save(original2); // "state 1" saved as memento 0 for original2

        manager.save(original3); // "state 5" saved as memento 0 for original3
        assertEquals("state 1", manager.load(original2, 0).getState());
        assertEquals("state 5", manager.load(original3, 0).getState());

        original1.setState("state 2");
        original1.setState("state 3");
        manager.save(original1); // "state 3" saved as memento 1 for original1
        assertEquals("state 3", manager.load(original1, 1).getState());


        original2.setState("state 100");
        original2.setState(manager.load(original2,0).getState()); // "state 1" loaded from memento 0 for original2
        assertEquals("state 1",original2.getState());


    }

}