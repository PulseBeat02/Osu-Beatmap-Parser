package com.github.pulsebeat02.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtilities {

    public static String getFileExtension(String name) {
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }

    public static void writeFileFromInputStream(InputStream input, File file) {
        try (OutputStream output = new FileOutputStream(file)) {
            input.transferTo(output);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean moveFileDirectory(String source, String target) {
        boolean moved = true;
        System.out.println("Source: " + source);
        System.out.println("Target: " + target);
        try {
            Files.move(Paths.get(source), Paths.get(target));
        } catch (Exception e) {
            moved = false;
            e.printStackTrace();
        }
        return moved;
    }

}
