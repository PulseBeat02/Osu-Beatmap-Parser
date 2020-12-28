package com.github.pulsebeat02.parse.structure.event;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;
import com.github.pulsebeat02.throwable.CorruptedBeatmapException;

import java.io.IOException;
import java.util.List;

public class BackgroundsCategory extends CommaSeparatedValueFactory {

    private final List<Background> backgrounds;

    public BackgroundsCategory(final OsuFile file, final List<Background> backgrounds) throws IOException {
        super("Backgrounds", file, BackgroundsCategory.class);
        this.backgrounds = backgrounds;
    }

    public List<Background> getBackgrounds() {
        return backgrounds;
    }

    private class Background {

        private final String fileName;
        private final int xOffSet;
        private final int yOffSet;

        public Background(final String fileName, final int xOffSet, final int yOffSet) {
            this.fileName = fileName;
            this.xOffSet = xOffSet;
            this.yOffSet = yOffSet;
        }

        public int getxOffSet() {
            return xOffSet;
        }

        public int getyOffSet() {
            return yOffSet;
        }

        public String getFileName() {
            return fileName;
        }

    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        for (String line : contents) {
            if (line.replaceAll(" ", "").startsWith("0,0")) {
                String[] parse = line.split(",");
                try {
                    String fileName = parse[2];
                    if (parse.length <= 3) {
                        backgrounds.add(new Background(fileName, 0, 0));
                    } else {
                        int xOffSet = Integer.parseInt(parse[3]);
                        int yOffSet = Integer.parseInt(parse[4]);
                        backgrounds.add(new Background(fileName, xOffSet, yOffSet));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new CorruptedBeatmapException("Corrupted Beatmap File!");
                }
            }
        }
    }

}
