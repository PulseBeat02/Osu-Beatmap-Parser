package com.github.pulsebeat02;

import com.github.pulsebeat02.file.OszFile;

import java.io.IOException;

public class OsuBeatMapTest {

    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        OszFile builder = new OszFile.OszFileBuilder()
                .setAudioPath(dir + "\\contents\\audio.mp3")
                .setVideoPath(dir + "\\contents\\video.mp4")
                .setBackgroundPath(dir + "\\contents\\")
                .setDifficultyPath(dir + "\\contents\\")
                .setHitSoundPath(dir + "\\contents\\sounds")
                .setVideo(true)
                .setName("KDA Popstars")
                .setPath(dir + "\\test\\popstars.osz")
                .build();

    }

}
