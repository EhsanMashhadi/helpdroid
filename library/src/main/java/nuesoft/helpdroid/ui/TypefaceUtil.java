package nuesoft.helpdroid.ui;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by Ehsan on 3/23/18.
 */

public class TypefaceUtil {

    public static void setTextViewsTypeface(View view, Typeface typeface) {

        if (view instanceof TextView) {
            ((TextView) view).setTypeface(typeface);
        }
        if (view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                setTextViewsTypeface(child, typeface);
            }
        }
    }

    public static void setTextInputLayoutTypeface(TextInputLayout textInputLayoutTypeface, Typeface typeface) throws NoSuchFieldException, IllegalAccessException {

        try {
            Field errorField = textInputLayoutTypeface.getClass().getDeclaredField("mErrorView");
            errorField.setAccessible(true);
            TextView textView = (TextView) errorField.get(textInputLayoutTypeface);
            textView.setTypeface(typeface);
            textView.setGravity(Gravity.START);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.START;
            textView.setLayoutParams(params);
        } catch (NoSuchFieldException e) {
            throw e;
        } catch (IllegalAccessException e) {
            throw e;
        }
    }

    public static void setBottomNavigationMenuStyle(BottomNavigationView navigationView, Typeface typeface) {

        Menu menu = navigationView.getMenu();

        for (int i = 0; i < menu.size(); i++) {

            MenuItem menuItem = menu.getItem(i);
            SpannableString spannableString = new SpannableString(menuItem.getTitle());
            spannableString.setSpan(new CustomTypefaceSpan("", typeface), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            menuItem.setTitle(spannableString);
        }
    }

    private static class CustomTypefaceSpan extends TypefaceSpan {

        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {

            super(family);
            newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {

            applyCustomTypeFace(ds, newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {

            applyCustomTypeFace(paint, newType);
        }

        private static void applyCustomTypeFace(Paint paint, Typeface tf) {

            int oldStyle;
            Typeface old = paint.getTypeface();
            if (old == null) {
                oldStyle = 0;
            } else {
                oldStyle = old.getStyle();
            }

            int fake = oldStyle & ~tf.getStyle();
            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(tf);

        }
    }
}


