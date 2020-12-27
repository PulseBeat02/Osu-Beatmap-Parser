package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;

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

}
