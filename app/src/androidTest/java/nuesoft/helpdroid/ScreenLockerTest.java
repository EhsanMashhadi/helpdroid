package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import nuesoft.helpdroid.util.ScreenLocker;

/**
 * Created by mysterious on 9/15/17.
 */

public class ScreenLockerTest {

    private double endTime = -1;

    @Test
    public void lockTest1Sec() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);


        double startTime = System.currentTimeMillis();
        ScreenLocker screenLocker = new ScreenLocker(1000, new ScreenLocker.LockInterface() {
            @Override
            public void locked() {
                endTime = System.currentTimeMillis();
                countDownLatch.countDown();
            }
        });

        screenLocker.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(endTime - startTime, 1000, 50);

    }

    @Test
    public void lockTest5Sec() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);


        double startTime = System.currentTimeMillis();
        ScreenLocker screenLocker = new ScreenLocker(5000, new ScreenLocker.LockInterface() {
            @Override
            public void locked() {
                endTime = System.currentTimeMillis();
                countDownLatch.countDown();
            }
        });

        screenLocker.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(endTime - startTime, 5000, 50);

    }

    @Test
    public void lockTest50Sec() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);


        double startTime = System.currentTimeMillis();
        ScreenLocker screenLocker = new ScreenLocker(50000, new ScreenLocker.LockInterface() {
            @Override
            public void locked() {
                endTime = System.currentTimeMillis();
                countDownLatch.countDown();
            }
        });

        screenLocker.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(endTime - startTime, 50000, 50);
    }
}