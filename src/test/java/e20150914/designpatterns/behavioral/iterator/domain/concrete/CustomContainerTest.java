package e20150914.designpatterns.behavioral.iterator.domain.concrete;

import e20150914.designpatterns.behavioral.iterator.domain.abs.Container;
import e20150914.designpatterns.behavioral.iterator.domain.abs.Iterator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by alex on 9/15/15.
 */
public class CustomContainerTest extends TestCase {

    @Test
    public void testIterator(){

        String[] testData = new String[]{"a","b","c"};

        Container<String> numContainer = new CustomContainer<>(testData);

        Iterator<String> it = numContainer.getIterator();

        while(it.hasNext()){
            String result = it.next();
            assertNotNull(result);

            // first test result must be equal to iterator result
            assertEquals(testData[0], result);

            // remove first test result from test data
            testData = Arrays.copyOfRange(testData,1,testData.length);
        }
    }

}