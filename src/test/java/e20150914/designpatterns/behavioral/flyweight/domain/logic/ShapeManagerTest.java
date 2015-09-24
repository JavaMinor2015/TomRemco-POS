package e20150914.designpatterns.behavioral.flyweight.domain.logic;

import e20150914.designpatterns.behavioral.flyweight.domain.abs.Shape;
import e20150914.designpatterns.behavioral.flyweight.domain.concrete.Circle;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class ShapeManagerTest extends TestCase {

    @Test
    public void testFlyweight(){
        String[] colors = new String[]{"red","white","blue"};
        ShapeManager manager = new ShapeManager();

        // can hold duplicates, so good for checking amount of circles vs. actual circle objects created
        List<Shape> circles = new ArrayList<>();

        for (String color : colors) {

            while(Math.random() > 0.2){
                Shape s = manager.getCircle(color);
                assertNotNull(s);
                assertTrue(s instanceof Circle);
                circles.add(s);
            }

            // make sure one is always added
            circles.add(manager.getCircle(color));
        }

        // we have equal or more circles in our list than there have been created
        assertTrue(circles.size() >= manager.getMap().size());

        // the manager only made a circle for each color
        assertTrue(colors.length==manager.getMap().size());


    }
}