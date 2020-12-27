package com.github.pulsebeat02;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.file.OszFile;

import java.util.List;

public class OsuBeatmap {

    private final OszFile file;
    private final List<OsuFile> difficulties;

    public OsuBeatmap(final OszFile file, final List<OsuFile> difficulties) {
        this.file = file;
        this.difficulties = difficulties;
    }

    public OszFile getFile() {
        return file;
    }

    public List<OsuFile> getDifficulties() {
        return difficulties;
    }


}
