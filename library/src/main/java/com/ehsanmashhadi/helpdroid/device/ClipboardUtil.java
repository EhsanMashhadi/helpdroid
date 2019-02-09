package com.ehsanmashhadi.helpdroid.device;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardUtil {

    public static void copyToClipboard(Context context, String label, String input) {

        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, input);
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
        }
    }
}