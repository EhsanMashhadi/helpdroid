package nuesoft.helpdroid.application;

import android.content.Context;
import android.content.Intent;

/**
 * Created by mysterious on 10/12/17.
 */

public class ApplicationUtil {

    public static void restartApplication(Context context) throws Exception {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent == null) {
            throw new Exception("Intent is null");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
