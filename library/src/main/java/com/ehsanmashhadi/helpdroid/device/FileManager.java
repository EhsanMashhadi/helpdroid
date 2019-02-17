package com.ehsanmashhadi.helpdroid.device;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

import androidx.annotation.NonNull;

/**
 * Created by mysterious on 9/16/17.
 */

public class FileManager {

    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream, int bufferSize) throws IOException {

        int length;
        byte[] buffer = new byte[bufferSize];
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        outputStream.flush();
        inputStream.close();
    }

    public static boolean delete(@NonNull String directory, @NonNull String fileName) {

        Objects.requireNonNull(directory);
        Objects.requireNonNull(fileName);
        File file = new File(directory + File.separator + fileName);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}