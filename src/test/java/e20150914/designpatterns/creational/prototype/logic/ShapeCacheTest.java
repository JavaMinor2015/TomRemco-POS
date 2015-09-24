package e20150914.designpatterns.creational.prototype.logic;

import e20150914.designpatterns.creational.prototype.domain.abs.Shape;
import e20150914.designpatterns.creational.prototype.domain.concrete.ShapeType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 9/14/15.
 */
public class ShapeCacheTest {

    @Test
    public void testShapeCache(){
        ShapeCache cache = new ShapeCache();

        Shape circle = cache.getShape(ShapeType.CIRCLE);
        Shape circle2 = cache.getShape(ShapeType.CIRCLE);

        Shape rectangle = cache.getShape(ShapeType.RECTANGLE);
        Shape rectangle2 = cache.getShape(ShapeType.RECTANGLE);

        Shape square = cache.getShape(ShapeType.SQUARE);
        Shape square2 = cache.getShape(ShapeType.SQUARE);

        assertEquals("Circle",circle.getType());
        assertEquals("Rectangle",rectangle.getType());
        assertEquals("Square",square.getType());

        assertTrue(circle != circle2);
        assertTrue(rectangle != rectangle2);
        assertTrue(square != square2);
    }

}