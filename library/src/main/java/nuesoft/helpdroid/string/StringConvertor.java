package nuesoft.helpdroid.string;

import java.util.IllformedLocaleException;

/**
 * Created by mysterious on 9/16/17.
 */

public class StringConvertor {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static byte[] parseHex(String hex) throws Exception {

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

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
