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
    private static ScreenLocker instance;

    private ScreenLocker() {

    }

    public static ScreenLocker getInstance() {

        if (instance == null) {
            instance = new ScreenLocker();
        }
        return instance;
    }

    public void init(int millisecondTime, final LockInterface lockInterface) {

        _handler = new Handler(Looper.getMainLooper());
        _time = millisecondTime;
        _runnable = new Runnable() {
            @Override
            public void run() {

                lockInterface.locked();
            }
        };
    }

    public void restart(int millisecondTime) {

        stop();
        this._time = millisecondTime;
        start();
    }

    public void start() {

        if (_runnable != null)
            _handler.postDelayed(_runnable, _time);
    }

    public void stop() {

        if (_runnable != null)
            _handler.removeCallbacks(_runnable);
    }
}