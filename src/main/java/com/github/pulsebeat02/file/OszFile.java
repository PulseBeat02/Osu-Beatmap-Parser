package com.github.pulsebeat02.file;

import com.github.pulsebeat02.throwable.VideoNotFoundException;
import com.github.pulsebeat02.utility.FileUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class OszFile {

    private final File file;
    private final ZipFile zip;
    private final File audio;
    private final File video;
    private final List<File> background;
    private final List<File> hitSounds;
    private final List<File> difficulties;
    private final String path;
    private final String name;

    public OszFile(final String path, final String name,
                   final String audioPath, final String videoPath, final String backgroundPath, final String hitSoundPath, final String difficultyPath,
                   final boolean video) throws IOException {
        this.file = new File(path);
        if (!(file.exists() || file.isFile())) {
            throw new FileNotFoundException("Osu Beatmap Not Found At: " + path);
        }
        this.zip = new ZipFile(path);
        this.audio = readAudioFile(audioPath);
        this.video = video ? readVideoFile(videoPath) : null;
        this.background = readBackgroundFiles(backgroundPath);
        this.hitSounds = readHitSounds(hitSoundPath);
        this.difficulties = readDifficulties(difficultyPath);
        this.path = path;
        this.name = name;
        zip.close();
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public ZipFile getZip() {
        return zip;
    }

    public boolean getVideoExists() {
        return video != null;
    }

    private File readAudioFile(final String path) throws IOException {
        File file = new File(path);
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().equals("audio.mp3")) {
                FileUtilities.writeFileFromInputStream(zip.getInputStream(entry), file);
                break;
            }

        }
        return file;
    }

    private File readVideoFile(final String path) throws IOException {
        File file = new File(path);
        boolean found = false;
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (FileUtilities.getFileExtension(entry.getName()).equals(".mp4")) {
                FileUtilities.writeFileFromInputStream(zip.getInputStream(entry), file);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new VideoNotFoundException("Video not found in File!");
        }
        return file;
    }

    private List<File> readBackgroundFiles(final String path) throws IOException {
        List<File> pictures = new ArrayList<>();
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            File file = new File(entry.getName());
            if (FileUtilities.getFileExtension(entry.getName()).equals(".jpg")) {
                FileUtilities.writeFileFromInputStream(zip.getInputStream(entry), file);
                FileUtilities.moveFileDirectory(file.getCanonicalPath(), path);
                pictures.add(file);
                break;
            }

        }
        return pictures;
    }

    private List<File> readHitSounds(final String path) throws IOException {
        List<File> hitsounds = new ArrayList<>();
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            File file = new File(entry.getName());
            if (FileUtilities.getFileExtension(entry.getName()).equals(".mp3") && !entry.getName().equals("audio.mp3")) {
                FileUtilities.writeFileFromInputStream(zip.getInputStream(entry), file);
                FileUtilities.moveFileDirectory(file.getCanonicalPath(), path);
                hitsounds.add(file);
                break;
            }

        }
        return hitsounds;
    }

    private List<File> readDifficulties(final String path) throws IOException {
        List<File> difficulties = new ArrayList<>();
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            File file = new File(entry.getName());
            if (FileUtilities.getFileExtension(entry.getName()).equals(".osu")) {
                FileUtilities.writeFileFromInputStream(zip.getInputStream(entry), file);
                FileUtilities.moveFileDirectory(file.getCanonicalPath(), path);
                difficulties.add(file);
                break;
            }

        }
        return difficulties;
    }

    public static class OszFileBuilder {

        private String path;
        private String name;
        private String audioPath;
        private String videoPath;
        private String backgroundPath;
        private String hitSoundPath;
        private String difficultyPath;
        private boolean video;

        public OszFileBuilder setPath(final String path) {
            this.path = path;
            return this;
        }

        public OszFileBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public OszFileBuilder setAudioPath(final String audioPath) {
            this.audioPath = audioPath;
            return this;
        }

        public OszFileBuilder setVideoPath(final String videoPath) {
            this.videoPath = videoPath;
            return this;
        }

        public OszFileBuilder setBackgroundPath(final String backgroundPath) {
            this.backgroundPath = backgroundPath;
            return this;
        }

        public OszFileBuilder setHitSoundPath(final String hitSoundPath) {
            this.hitSoundPath = hitSoundPath;
            return this;
        }

        public OszFileBuilder setDifficultyPath(final String difficultyPath) {
            this.difficultyPath = difficultyPath;
            return this;
        }

        public OszFileBuilder setVideo(final boolean video) {
            this.video = video;
            return this;
        }

        public OszFile build() throws IOException {
            return new OszFile(path, name, audioPath, videoPath, backgroundPath, hitSoundPath, difficultyPath, video);
        }

    }

}
