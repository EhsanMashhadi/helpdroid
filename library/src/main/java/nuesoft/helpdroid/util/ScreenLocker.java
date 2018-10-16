package nuesoft.helpdroid.util;

import android.os.Handler;
import android.os.Looper;

public class ScreenLocker {

    private Handler mHandler;
    private Runnable mRunnable;
    private int mTime;
    private static ScreenLocker sInstance;

    public interface LockScreenInterface {
        void lock();
    }

    private ScreenLocker() {

    }

    public static ScreenLocker getInstance() {

        if (sInstance == null) {
            sInstance = new ScreenLocker();
        }
        return sInstance;
    }

    public synchronized void init(int millisecondTime, LockScreenInterface lockScreenInterface) {

        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTime = millisecondTime;
        this.mRunnable = () -> {

            stop();
            lockScreenInterface.lock();
        };
    }

    public synchronized void restart(int millisecondTime) {

        this.stop();
        this.mTime = millisecondTime;
        this.start();
    }

    public synchronized void start() {

        if (this.mRunnable != null) {
            this.mHandler.postDelayed(this.mRunnable, (long) this.mTime);
        }
    }

    public synchronized void stop() {

        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public synchronized boolean isRunning() {

        return (this.mHandler != null);
    }
}
