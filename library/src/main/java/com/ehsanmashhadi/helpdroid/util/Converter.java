package com.ehsanmashhadi.helpdroid.util;

/**
 * Created by mysterious on 10/23/17.
 */

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Objects;

import androidx.annotation.NonNull;

public class Converter {


    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * Return byte array which consists values of hex string
     *
     * @param hex The desired hex string.
     * @return Returns a byte array.
     * @throws IllegalLengthException If {@code hex} length is not even.
     * @throws IllegalHexCharacter    If {@code hex} contains invalid hex characters
     * @throws NullPointerException   if {@code hex} is null
     */
    public static byte[] hexStringToBytes(@NonNull String hex) throws IllegalHexCharacter
            , IllegalLengthException {
        Objects.requireNonNull(hex);
        int length = hex.length();
        if (length % 2 != 0) {
            throw new IllegalLengthException("Illegal string length: " + length);
        }

        int bytesLength = length / 2;
        byte[] bytes = new byte[bytesLength];
        int idxChar = 0;
        for (int i = 0; i < bytesLength; i++) {
            int value = parseHexCharacter(hex.charAt(idxChar++)) << 4;
            value |= parseHexCharacter(hex.charAt(idxChar++));
            bytes[i] = (byte) value;
        }
        return bytes;
    }

    private static int parseHexCharacter(char c) throws IllegalHexCharacter {

        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('A' <= c && c <= 'F') {
            return c - 'A' + 10;
        } else if ('a' <= c && c <= 'f') {
            return c - 'a' + 10;
        }
        throw new IllegalHexCharacter("Illegal hex digit: " + c);
    }

    /**
     * Return hex string of input bytes
     *
     * @param bytes The desired byte array.
     * @return Returns a hex string.
     * @throws NullPointerException if {@code bytes} is null
     */
    public static String bytesToHexString(@NonNull byte[] bytes) {
        Objects.requireNonNull(bytes);
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Return DP value of input PX
     *
     * @param dp      The desired dp value.
     * @param context The context.
     * @return Returns a PX value.
     * @throws NullPointerException if {@code context} is null
     */
    public static float dpToPx(float dp, Context context) {
        Objects.requireNonNull(context);
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * Return PX value of input DP
     *
     * @param px      The desired px value.
     * @param context The context.
     * @return Returns a DP value.
     * @throws NullPointerException if {@code context} is null
     */
    public static float pxToDp(float px, Context context) {
        Objects.requireNonNull(context);
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static class IllegalLengthException extends Exception {

        IllegalLengthException(String exception) {
            super(exception);
        }
    }

    public static class IllegalHexCharacter extends Exception {
        IllegalHexCharacter(String exception) {
            super(exception);
        }
    }
}



