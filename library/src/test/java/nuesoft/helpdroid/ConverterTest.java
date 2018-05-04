package nuesoft.helpdroid;



import org.junit.Test;

import nuesoft.helpdroid.util.Converter;

import org.junit.Assert;

/**
 * Created by mysterious on 9/16/17.
 */

public class ConverterTest {

    @Test
    public void stringToHex() {

        try {
            byte[] byteArray = Converter.hexStringToBytes("A1B2C3");
            Assert.assertNotNull(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void stringToHexWrongLength() {

        try {
            Converter.hexStringToBytes("a1b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringToHexWrongDigit() {

        try {
            Converter.hexStringToBytes("WRONGDIGIT");
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
        String hexString = Converter.bytesToHexString(bytes);
        Assert.assertEquals(hexString, "A1B2C3");
    }

    @Test
    public void byteArrayToStringTest(){

        byte[] bytes=new byte[2];
        bytes[0]=65;
        bytes[1]=66;
        Assert.assertEquals("AB",Converter.byteArrayToString(bytes));
        Assert.assertNotEquals("",Converter.byteArrayToString(bytes));
        Assert.assertNotEquals(null,Converter.byteArrayToString(bytes));
    }

    @Test
    public void byteArrayToUnicodeString(){

        byte[] bytes=new byte[2];
        bytes[0]=65;
        bytes[1]=66;
        Assert.assertEquals("AB",Converter.byteArrayToUnicodeString(bytes));

    }

}
