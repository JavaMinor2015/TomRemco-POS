package e20150914.designpatterns.structural.decorator.domain.abs;

import e20150914.designpatterns.structural.decorator.domain.concrete.Circle;
import e20150914.designpatterns.structural.decorator.domain.concrete.DashedDecorator;
import e20150914.designpatterns.structural.decorator.domain.concrete.RedBorderDecorator;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class ShapeTest extends TestCase {

    @Test
    public void testDecorator(){
        Shape circle = new Circle();
        Shape redBorderedCircle = new RedBorderDecorator(circle);
        Shape dashedRedBorderedCircle = new DashedDecorator(redBorderedCircle);

        assertEquals(" Dashed  Red Bordered  Circle ",dashedRedBorderedCircle.draw());

        Shape dashedDashedCircle = new DashedDecorator(new DashedDecorator(new Circle()));
        assertEquals(" Dashed  Dashed  Circle ",dashedDashedCircle.draw());
    }

}