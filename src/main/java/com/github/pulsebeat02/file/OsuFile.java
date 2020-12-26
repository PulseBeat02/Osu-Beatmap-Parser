package com.github.pulsebeat02.file;

import java.io.File;
import java.io.FileNotFoundException;

public class OsuFile {

    private final File file;
    private final String path;
    private final String name;

    public OsuFile(final String path, final String name) throws FileNotFoundException {
        this.file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Osu Beatmap not Found at: " + path);
        }
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

}
