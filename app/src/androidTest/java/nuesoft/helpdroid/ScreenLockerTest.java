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
        ScreenLocker.getInstance().init(5000, () -> {

            endTime = System.currentTimeMillis();
            countDownLatch.countDown();
        });

        ScreenLocker.getInstance().start();

        ScreenLocker.getInstance().restart(1000);

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
        ScreenLocker.getInstance().init(5000, new ScreenLocker.LockScreenInterface() {
            @Override
            public void lock() {

                endTime = System.currentTimeMillis();
                countDownLatch.countDown();
            }
        });

        ScreenLocker.getInstance().start();
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
        ScreenLocker.getInstance().init(50000, new ScreenLocker.LockScreenInterface() {
            @Override
            public void lock() {

                endTime = System.currentTimeMillis();
                countDownLatch.countDown();
            }
        });

        ScreenLocker.getInstance().start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(endTime - startTime, 50000, 100);
    }
}