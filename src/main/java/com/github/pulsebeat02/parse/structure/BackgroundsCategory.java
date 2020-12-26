package com.github.pulsebeat02.parse.structure;

import java.util.List;

public class BackgroundsCategory {

    private final List<Background> backgrounds;

    public BackgroundsCategory(final List<Background> backgrounds) {
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
