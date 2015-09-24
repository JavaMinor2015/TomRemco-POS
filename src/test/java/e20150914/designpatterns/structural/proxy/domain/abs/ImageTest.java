package e20150914.designpatterns.structural.proxy.domain.abs;

import e20150914.designpatterns.structural.proxy.domain.concrete.ProxyImage;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/14/15.
 */
public class ImageTest extends TestCase {
    @Test
    public void testProxy(){
        Image image = new ProxyImage("filename");

        // load on first time, merely show otherwise
        assertEquals("Loading filename",image.show());
        assertEquals("Showing filename",image.show());
        assertEquals("Showing filename",image.show());

    }
}