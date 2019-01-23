package com.ehsanmashhadi.helpdroid.ui;

import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

public class SnackBar {

    public static void showSnackBar(View view, String message, int backgroundColor, int textColor, Typeface typeface) {

        final Snackbar snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackBar.getView().setBackgroundColor(backgroundColor);
        TextView textView = (TextView) (snackBar.getView()).findViewById(android.support.design.R.id.snackbar_text);
        textView.setTypeface(typeface);
        textView.setTextColor(textColor);
        snackBar.show();

    }

    public static void showSnackBar(View view, String message) {

        final Snackbar snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackBar.show();

    }
}