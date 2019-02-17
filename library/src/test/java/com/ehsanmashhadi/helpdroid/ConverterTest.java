package com.ehsanmashhadi.helpdroid;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.ehsanmashhadi.helpdroid.util.Converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by mysterious on 9/16/17.
 */

public class ConverterTest {

    @Mock
    Context mContext;

    @Mock
    Resources mResources;

    @Mock
    DisplayMetrics mDisplayMetrics;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mContext.getResources()).thenReturn(mResources);
        Mockito.when(mResources.getDisplayMetrics()).thenReturn(mDisplayMetrics);
    }

    @Test
    public void testHexStringToBytes() throws Exception {

        byte[] bytes = Converter.hexStringToBytes("A1b2C3");
        byte[] expectedResult = {-95, -78, -61};
        Assert.assertArrayEquals(bytes, expectedResult);
    }


    @Test(expected = Converter.IllegalHexCharacter.class)
    public void testHexStringToBytes_invalidCharacters() throws Exception {

        Converter.hexStringToBytes("A1B2C+");
    }

    @Test(expected = Converter.IllegalLengthException.class)
    public void testHexStringToBytes_invalidLength() throws Exception {

        Converter.hexStringToBytes("ABC");
    }

    @Test
    public void testBytesToHexString() {
        byte[] bytes = {-95, -78, -61};
        String hexString = Converter.bytesToHexString(bytes);
        Assert.assertEquals(hexString, "A1B2C3");
    }


    @Test
    public void testDpToPx_ldpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_LOW;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 7.5, 0);
    }

    @Test
    public void testDpToPx_mdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_MEDIUM;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 10, 0);
    }

    @Test
    public void testDpToPx_tv() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_TV;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 13.3125, 0);
    }

    @Test
    public void testDpToPx_hdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_HIGH;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 15, 0);
    }

    @Test
    public void testDpToPx_xhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XHIGH;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 20, 0);
    }

    @Test
    public void testDpToPx_xxhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XXHIGH;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 30, 0);
    }

    @Test
    public void testDpToPx_xxxhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XXXHIGH;
        float px = Converter.dpToPx(10, mContext);
        Assert.assertEquals(px, 40, 0);
    }

    @Test
    public void testPxToDp_ldpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_LOW;
        float dp = Converter.pxToDp((float) 7.5, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_mdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_MEDIUM;
        float dp = Converter.pxToDp(10, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_tv() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_TV;
        float dp = Converter.pxToDp((float) 13.3125, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_hdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_HIGH;
        float dp = Converter.pxToDp(15, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_xhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XHIGH;
        float dp = Converter.pxToDp(20, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_xxhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XXHIGH;
        float dp = Converter.pxToDp(30, mContext);
        Assert.assertEquals(dp, 10, 0);
    }

    @Test
    public void testPxToDp_xxxhdpi() {

        mDisplayMetrics.densityDpi = DisplayMetrics.DENSITY_XXXHIGH;
        float dp = Converter.pxToDp(40, mContext);
        Assert.assertEquals(dp, 10, 0);
    }
}