package e20150914.designpatterns.creational.abstractFactory;

import e20150914.designpatterns.creational.abstractFactory.logic.AbstractPlatformFactory;
import e20150914.designpatterns.creational.abstractFactory.logic.AndroidFactory;
import e20150914.designpatterns.creational.abstractFactory.logic.WindowsFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 9/14/15.
 */
public class AbstractPlatformFactoryTest {

    @Test
    public void testAbstractFactory(){
        final AbstractPlatformFactory windowsFactory = new WindowsFactory();
        final AbstractPlatformFactory androidFactory = new AndroidFactory();

        windowsFactory.createScrollbar();
        windowsFactory.createWindow();

        assertEquals("Windows Scrollbar", windowsFactory.getPlatform().getScrollbar().toString());
        assertEquals("Windows Window", windowsFactory.getPlatform().getWindow().toString());

        androidFactory.createScrollbar();
        androidFactory.createWindow();

        assertEquals("Android Scrollbar", androidFactory.getPlatform().getScrollbar().toString());
        assertEquals("Android Window", androidFactory.getPlatform().getWindow().toString());

    }

}