package nuesoft.helpdroid.util;

/**
 * Created by mysterious on 10/23/17.
 */

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;

public class Converter {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static byte[] hexStringToBytes(String hex) throws Exception {

        int length = hex.length();
        if (length % 2 != 0) {
            throw new Exception("Illegal string length: " + length);
        }

        int bytesLength = length / 2;
        byte[] bytes = new byte[bytesLength];
        int idxChar = 0;
        for (int i = 0; i < bytesLength; i++) {
            int value = parseHexDigit(hex.charAt(idxChar++)) << 4;
            value |= parseHexDigit(hex.charAt(idxChar++));
            bytes[i] = (byte) value;
        }
        return bytes;
    }

    public static int parseHexDigit(char c) throws Exception {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('A' <= c && c <= 'F') {
            return c - 'A' + 10;
        } else if ('a' <= c && c <= 'f') {
            return c - 'a' + 10;
        }
        throw new Exception("Illegal hex digit: " + c);
    }

    public static String bytesToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static String byteArrayToString(byte[] value) {

        String strValue = new String(value, 0, value.length).trim();
        return strValue;
    }

    public static String byteArrayToUnicodeString(byte[] value) {

        String strValue = null;
        try {
            strValue = new String(value, 0, value.length, "UTF-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strValue;
    }


    public static byte[] longToByteArrayLittleEndian(long value) {

        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(value);
        return buffer.array();
    }

    public static byte[] longToByteArrayBigEndian(long value) {

        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putLong(value);
        return buffer.array();
    }

    public static long byteArrayToLongBigEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getLong();
    }

    public static long byteArrayToLongLittleEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getLong();
    }

    public static short byteArrayToShortBigEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getShort();
    }

    public static short byteArrayToShortLittleEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getShort();
    }

    public static byte byteArrayToByteLittleEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.get(0);
    }

    public static byte byteArrayToByteBigEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.get(0);
    }

    public static int byteArrayToIntLittleEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt();
    }

    public static int byteArrayToIntBigEndian(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getInt();
    }

    public static String getTimeISOFormat(long timestamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateTimeString = simpleDateFormat.format(new java.util.Date(timestamp * 1000));
        return dateTimeString;
    }

    public static float dpToPx(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float pxToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

}