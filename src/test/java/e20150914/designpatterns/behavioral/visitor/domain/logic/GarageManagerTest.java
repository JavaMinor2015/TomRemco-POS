package e20150914.designpatterns.behavioral.visitor.domain.logic;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class GarageManagerTest extends TestCase {

    @Test
    public void testVisitor(){
        GarageManager manager = new GarageManager();
        manager.startWalking();
        assertEquals(6.50f,manager.getTotalPrice());
    }
}