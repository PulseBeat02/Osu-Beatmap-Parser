package com.github.pulsebeat02;

import com.github.pulsebeat02.file.OszFile;

import java.io.IOException;

public class OsuBeatMapTest {

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        OszFile file = new OszFile(dir + "\\test\\popstars.osz", dir + "\\contents");
        System.out.println(file);
    }

}
