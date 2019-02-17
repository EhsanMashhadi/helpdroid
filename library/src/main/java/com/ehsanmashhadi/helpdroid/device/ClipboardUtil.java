package com.ehsanmashhadi.helpdroid.device;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.util.Objects;

import androidx.annotation.NonNull;

public class ClipboardUtil {

    public static void copyToClipboard(@NonNull Context context, String label, @NonNull String input) {

        Objects.requireNonNull(context);
        Objects.requireNonNull(input);
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, input);
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
        }
    }
}