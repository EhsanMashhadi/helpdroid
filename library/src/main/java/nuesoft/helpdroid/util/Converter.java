package nuesoft.helpdroid.util;

/**
 * Created by mysterious on 10/23/17.
 */

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;

public class Converter {

    public static byte[] hexStringToByteArray(String s) {

        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String byteArrayToHexString(byte[] bytes) {

        char[] hexArray = "0123456789ABCDEF".toCharArray();
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

    public static int byteArrayToIntLittleEndiant(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt();
    }

    public static int byteArrayToIntBigEndiant(byte[] value) {

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getInt();
    }

    public static String getTimeISOFormat(long timestamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateTimeString = simpleDateFormat.format(new java.util.Date(timestamp * 1000));
        return dateTimeString;
    }


}