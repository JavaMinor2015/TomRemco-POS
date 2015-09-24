package e20150914.designpatterns.creational.factoryMethod.logic;

import e20150914.designpatterns.creational.factoryMethod.domain.abs.Shape;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Circle;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Rectangle;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.ShapeType;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Square;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class CreatorTest extends TestCase {

    @Test
    public void testFactoryMethod(){
        Creator creator = new ConcreteCreator();

        Shape circle = creator.create(ShapeType.CIRCLE);
        Shape rectangle = creator.create(ShapeType.RECTANGLE);
        Shape square = creator.create(ShapeType.SQUARE);

        assertTrue(circle instanceof Circle);
        assertTrue(rectangle instanceof Rectangle);
        assertTrue(square instanceof Square);
    }

}