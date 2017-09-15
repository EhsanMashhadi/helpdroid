package nuesoft.helpdroid.util;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Mysterious on 17/05/2016.
 */


public class ScreenLocker {

    public interface LockInterface {
        void locked();
    }

    private Handler _handler;
    private Runnable _runnable;
    private int _time;

    public ScreenLocker(int miliSecTime, final LockInterface lockInterface) {

        _handler = new Handler(Looper.getMainLooper());
        _time = miliSecTime;
        _runnable = new Runnable() {
            @Override
            public void run() {
                lockInterface.locked();
            }
        };
    }

    public void start() {
        _handler.postDelayed(_runnable, _time);
    }

    public void stop() {
        _handler.removeCallbacks(_runnable);
    }
}