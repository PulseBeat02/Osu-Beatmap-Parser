package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;

import java.io.IOException;
import java.util.List;

public class VideosCategory extends CommaSeparatedValueFactory {

    private final List<Video> videos;

    public VideosCategory(final OsuFile file, final List<Video> videos) throws IOException {
        super("Videos", file, VideosCategory.class);
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    private class Video {

        private final int startTime;
        private final int xOffSet;
        private final int yOffSet;
        private final String fileName;

        public Video(final int startTime, final int xOffSet, final int yOffSet, final String fileName) {
            this.startTime = startTime;
            this.xOffSet = xOffSet;
            this.yOffSet = yOffSet;
            this.fileName = fileName;
        }

        public int getStartTime() {
            return startTime;
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
