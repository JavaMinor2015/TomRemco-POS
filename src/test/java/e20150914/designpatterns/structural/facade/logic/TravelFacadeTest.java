package e20150914.designpatterns.structural.facade.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 9/14/15.
 */
public class TravelFacadeTest {
    @Test
    public void testFacade(){
        assertEquals("KLM flies to Hilton",new TravelFacade().getFlightToHotel("Hilton"));
        assertEquals("NorthWest flies to Travel Lodge",new TravelFacade().getFlightToHotel("Travel Lodge"));
        assertEquals("No flights found",new TravelFacade().getFlightToHotel("B&B"));
    }
}