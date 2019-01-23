package com.ehsanmashhadi.helpdroid.device;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mysterious on 9/16/17.
 */

public class FileManager {

    public static void copy(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {

        try {
            int length;
            byte[] buffer = new byte[bufferSize];
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            outputStream.flush();
            inputStream.close();
        } catch (IOException exception) {
            throw exception;
        }
    }

    public static void delete(String directory, String fileName) {

        File databaseFile = new File(directory + File.separator + fileName);
        if (databaseFile.exists()) {
            boolean result = databaseFile.delete();
        }
    }
}