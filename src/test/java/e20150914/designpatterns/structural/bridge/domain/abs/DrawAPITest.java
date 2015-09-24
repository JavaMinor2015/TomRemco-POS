package e20150914.designpatterns.structural.bridge.domain.abs;

import e20150914.designpatterns.structural.bridge.domain.concrete.drawapis.GreenCircle;
import e20150914.designpatterns.structural.bridge.domain.concrete.drawapis.RedCircle;
import e20150914.designpatterns.structural.bridge.domain.concrete.shapes.Circle;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class DrawAPITest extends TestCase {

    @Test
    public void testBridgeAdapter(){
        Shape greenCircle = new Circle(new GreenCircle(),5);
        Shape redCircle = new Circle(new RedCircle(),10);

        assertEquals("Green circle: 5",greenCircle.draw());
        assertEquals("Red circle: 10",redCircle.draw());
    }

}