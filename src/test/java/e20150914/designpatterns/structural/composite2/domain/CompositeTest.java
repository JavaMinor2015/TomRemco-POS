package e20150914.designpatterns.structural.composite2.domain;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class CompositeTest extends TestCase {

    @Test
    public void testComposite2(){

        Component root = new Composite();
        Component composite1 = new Composite();
        Component leaf1 = new Leaf();
        composite1.addComponent(leaf1);
        root.addComponent(composite1);

        Component leaf2 = new Leaf();
        root.addComponent(leaf2);

        assertEquals("Composite", root.getChild(0).getName());
        assertEquals("Leaf",root.getChild(1).getName());
        assertEquals("Leaf",root.getChild(0).getChild(0).getName());
    }
}