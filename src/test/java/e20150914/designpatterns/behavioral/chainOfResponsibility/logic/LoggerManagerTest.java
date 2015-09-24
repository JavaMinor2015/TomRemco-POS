package e20150914.designpatterns.behavioral.chainOfResponsibility.logic;

import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.abs.AbstractLogger;
import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.LoggerLevel;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/15/15.
 */
public class LoggerManagerTest extends TestCase {

    @Test
    public void testResponsibilityChain(){
        AbstractLogger logger = LoggerManager.getLogger();

        // note, not a proper logger, only for pattern demonstration
        // normally error message would also show up on debug level etc.

        assertEquals("INFO: message",logger.log(LoggerLevel.INFO,"message"));
        assertEquals("DEBUG: message",logger.log(LoggerLevel.DEBUG,"message"));
        assertEquals("ERROR: message",logger.log(LoggerLevel.ERROR,"message"));
    }

}