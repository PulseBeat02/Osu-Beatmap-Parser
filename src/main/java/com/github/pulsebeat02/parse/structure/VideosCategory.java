package com.github.pulsebeat02.parse.structure;

import java.util.List;

public class VideosCategory {

    private final List<Video> videos;

    public VideosCategory(List<Video> videos) {
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
