package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import nuesoft.helpdroid.test.Order;
import nuesoft.helpdroid.test.OrderedRunner;

/**
 * Created by mysterious on 2/12/18.
 */

@RunWith(OrderedRunner.class)
public class OrderTest {

    private static int counter;

    @Test
    @Order(order = 1)
    public void firsMethod() {

        counter = counter + 1;
        Assert.assertEquals(counter, 1);
    }

    @Test
    @Order(order = 2)
    public void secondMethod() {

        counter = counter + 1;
        Assert.assertEquals(counter, 2);
    }

    @Test
    @Order(order = 3)
    public void thirdMethod() {

        counter = counter + 1;
        Assert.assertEquals(counter, 3);
    }

    @Test
    @Order(order = 4)
    public void forthMethod() {

        counter = counter + 1;
        Assert.assertEquals(counter, 4);
    }
}