package e20150914.designpatterns.behavioral.observer.domain.abs;

import e20150914.designpatterns.behavioral.observer.domain.concrete.NumObserver;
import e20150914.designpatterns.behavioral.observer.domain.concrete.Subject;
import e20150914.designpatterns.behavioral.observer.domain.concrete.TextObserver;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class ObserverTest extends TestCase {
    @Test
    public void testObserver(){
        Subject subjectToChange = new Subject();

        Observer textObserver = new TextObserver(subjectToChange);
        Observer numObserver = new NumObserver(subjectToChange);

        subjectToChange.setState("thisIsText");
        assertTrue("thisIsText".equals(textObserver.getLastState()));
        assertNull(numObserver.getLastState());

        subjectToChange.setState("123456");
        assertTrue("123456".equals(numObserver.getLastState()));
        assertTrue("thisIsText".equals(textObserver.getLastState()));

        subjectToChange.detach(textObserver);
        subjectToChange.setState("thisIsTextAgain");
        assertTrue("thisIsText".equals(textObserver.getLastState()));
        assertTrue("123456".equals(numObserver.getLastState()));

    }
}