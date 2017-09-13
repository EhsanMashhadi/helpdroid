package nuesoft.helpdroid.device;

import android.content.Context;

import com.scottyab.rootbeer.RootBeer;

/**
 * Created by mysterious on 9/3/17.
 */

public class RootChecker {

    public static boolean isRooted(Context context) {
        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRooted();
    }

    public static boolean isRootedWithoutBusyBox(Context context) {
        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRootedWithoutBusyBoxCheck();
    }
}
