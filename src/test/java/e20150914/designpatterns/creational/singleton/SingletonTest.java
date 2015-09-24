package e20150914.designpatterns.creational.singleton;

import org.junit.Test;

import static e20150914.designpatterns.creational.singleton.Singleton.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 9/14/15.
 */
public class SingletonTest {

    @Test
    public void testSingleton(){
        final Singleton singleton1 = Singleton.getInstance();
        final Singleton singleton2 = Singleton.getInstance();

        assertTrue(singleton1==singleton2);

        final Single single1 = Singleton.getInstance().getSingle();
        final Single single2 = Singleton.getInstance().getSingle();

        assertTrue(single1==single2);

    }

}