package nuesoft.helpdroid;

import junit.framework.Assert;

import org.junit.Test;

import nuesoft.helpdroid.string.StringConvertor;

/**
 * Created by mysterious on 9/16/17.
 */

public class StringTest {

    @Test
    public void stringToHex() {

        try {
            byte[] byteArray = StringConvertor.parseHex("A1B2C3");
            Assert.assertNotNull(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void stringToHexWrongLength() {

        try {
            StringConvertor.parseHex("a1b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringToHexWrongDigit() {

        try {
            StringConvertor.parseHex("WRONGDIGIT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bytesToHex() {
        byte[] bytes = new byte[3];
        bytes[0] = -95;
        bytes[1] = -78;
        bytes[2] = -61;
        String hexString = StringConvertor.bytesToHex(bytes);
        Assert.assertEquals(hexString, "A1B2C3");
    }
}
