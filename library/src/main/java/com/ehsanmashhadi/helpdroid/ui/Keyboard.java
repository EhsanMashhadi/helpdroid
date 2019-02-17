package com.ehsanmashhadi.helpdroid.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Objects;

import androidx.annotation.NonNull;

/**
 * Created by mysterious on 9/15/17.
 */

public class Keyboard {

    public static boolean hideKeyboard(@NonNull View view) {

        Objects.requireNonNull(view);
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean showKeyboard(@NonNull View view) {

        Objects.requireNonNull(view);
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void dismissKeyboardTapAround(@NonNull final View view) {

        Objects.requireNonNull(view);
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                hideKeyboard(view);
                return false;
            });
        }
        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                dismissKeyboardTapAround(innerView);
            }
        }
    }
}