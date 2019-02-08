package com.ehsanmashhadi.helpdroid.app;

import android.content.Context;
import androidx.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ehsanmashhadi.helpdroid.device.FileManager;

/**
 * Created by mysterious on 9/16/17.
 */

public class FileManagerTest {

    private static String _filePath;
    private static String _destination;
    private static String _fileName;
    private String assetFolder = "database";
    final String databaseAssetFolder = "database";


    @BeforeClass
    public static void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        _filePath = context.getFilesDir().getAbsolutePath();
        _fileName = "icd.sqlite";
        _destination = _filePath + File.separator + _fileName;
    }

    @Before
    public void delete() {
        FileManager.delete(_filePath, _fileName);
    }

    @Test
    public void testCopy() {

        Context context = InstrumentationRegistry.getTargetContext();

        String filesList[] = new String[0];
        try {
            filesList = context.getAssets().list(assetFolder);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }

        File databaseFile = new File(_destination);

        if (!databaseFile.exists()) {
            boolean isSuccess = false;
            try {
                isSuccess = databaseFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Assert.fail();

            }

            if (isSuccess) {
                String source = databaseAssetFolder + File.separator + _fileName;
                InputStream inputStream = null;
                try {
                    inputStream = context.getAssets().open(source);
                    OutputStream outputStream = new FileOutputStream(_destination);
                    long firstTime = System.currentTimeMillis();
                    FileManager.copy(inputStream, outputStream, 8192);
                    long secondTime = System.currentTimeMillis();
                    System.out.println("Time" + (secondTime - firstTime));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
