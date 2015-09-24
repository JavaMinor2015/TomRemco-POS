package e20150914.designpatterns.behavioral.memento2.logic;

import e20150914.designpatterns.behavioral.memento2.domain.Original;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by alex on 9/16/15.
 */
public class MementoManagerTest extends TestCase {
    @Test
    public void testMemento() throws IOException {

        Path p = Paths.get(System.getProperty("user.dir")+"/Serial.dat");

        MementoManager manager = new MementoManager(p.toString());

        Original original1 = new Original(1);
        Original original2 = new Original(2);
        Original original3 = new Original(3);


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