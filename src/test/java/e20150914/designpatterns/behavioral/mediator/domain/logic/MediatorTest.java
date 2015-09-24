package e20150914.designpatterns.behavioral.mediator.domain.logic;

import e20150914.designpatterns.behavioral.mediator.domain.abs.Device;
import e20150914.designpatterns.behavioral.mediator.domain.abs.User;
import e20150914.designpatterns.behavioral.mediator.domain.concrete.Customer;
import e20150914.designpatterns.behavioral.mediator.domain.concrete.Mobile;
import e20150914.designpatterns.behavioral.mediator.domain.concrete.Pager;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class MediatorTest extends TestCase {

    @Test
    public void testMediator(){

        List<User> userList = Arrays.asList(new User[]{new Customer("customer1"),new Customer("customer2"),new Customer("customer3")});
        List<Device> deviceList = Arrays.asList(new Device[]{new Pager(),new Pager(),new Mobile()});

        Mediator messageMediator = new Mediator(deviceList);

        for (User user : userList) {
            String message = "Hi! How are you?";
            StringBuilder b = new StringBuilder();
            b.append("Pager: " + user.getName() + " " + message);
            b.append("Pager: " + user.getName() + " " + message);
            b.append("Mobile: " + user.getName() + " " + message);

            assertEquals(b.toString(),messageMediator.sendMessage(user,message));
        }

    }

}