package com.github.pulsebeat02.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtilities {

    public static String getFileExtension(final String name) {
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }

    public static void writeFileFromInputStream(final InputStream input, final File file) {
        try (OutputStream output = new FileOutputStream(file)) {
            input.transferTo(output);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean moveFileDirectory(final String source, final String target) {
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

    public static void unZipFile(final String source, final String destination) throws IOException {
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(source));
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            String filePath = destination + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                byte[] bytesIn = new byte[4096];
                int read = 0;
                while ((read = zipIn.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }
                bos.close();
            } else {
                new File(filePath).mkdirs();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

}
