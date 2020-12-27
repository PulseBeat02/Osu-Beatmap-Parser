package com.github.pulsebeat02.file;

import com.github.pulsebeat02.throwable.CorruptedBeatmapException;
import com.github.pulsebeat02.utility.FileUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipFile;

public class OszFile {

    private final File osz;
    private final File destination;
    private final ZipFile zip;
    private final File audio;
    private final File video;
    private final List<File> background;
    private final List<File> hitSounds;
    private final List<File> difficulties;

    public OszFile(final String path, final String extractionPath) throws IOException {
        this.osz = new File(path);
        if (!(osz.exists() || osz.isFile())) {
            throw new FileNotFoundException("Osu Beatmap Not Found At: " + path);
        }
        this.destination = new File(extractionPath);
        this.zip = new ZipFile(path);
        FileUtilities.unZipFile(path, extractionPath);
        this.audio = getAudioFile();
        this.video = getVideoFile();
        this.background = getBackgroundPictures();
        this.hitSounds = getHitSounds();
        this.difficulties = getDifficulties();
        zip.close();
    }

    public ZipFile getZip() {
        return zip;
    }

    public boolean getVideoExists() {
        return video != null;
    }

    public File getAudioFile() throws IOException {
        for (File f : Objects.requireNonNull(destination.listFiles())) {
            if (f.getName().equals("audio.mp3")) {
                return f;
            }
        }
        throw new CorruptedBeatmapException("Audio not found for Osu File: " + osz.getCanonicalPath());
    }

    public File getVideoFile() throws IOException {
        for (File f : Objects.requireNonNull(destination.listFiles())) {
            if (FileUtilities.getFileExtension(f.getName()).equals(".mp4")) {
                return f;
            }
        }
        return null;
    }

    public List<File> getBackgroundPictures() {
        List<File> files = new ArrayList<>();
        for (File f : Objects.requireNonNull(destination.listFiles())) {
            if (FileUtilities.getFileExtension(f.getName()).equals(".jpg")) {
                files.add(f);
            }
        }
        return files;
    }

    public List<File> getHitSounds() {
        List<File> files = new ArrayList<>();
        for (File f : Objects.requireNonNull(destination.listFiles())) {
            String name = f.getName();
            if (FileUtilities.getFileExtension(name).equals(".wav")) {
                files.add(f);
            }
        }
        return files;
    }

    private List<File> getDifficulties() {
        List<File> files = new ArrayList<>();
        for (File f : Objects.requireNonNull(destination.listFiles())) {
            String name = f.getName();
            if (FileUtilities.getFileExtension(name).equals(".osu")) {
                files.add(f);
            }
        }
        return files;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("File Path: ");
        try {
            sb.append(osz.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append(System.lineSeparator());
        sb.append("Audio File: ").append(audio);
        sb.append(System.lineSeparator());
        sb.append("Video File: ").append(video);
        sb.append(System.lineSeparator());
        sb.append("Background Files: ").append(background);
        sb.append(System.lineSeparator());
        sb.append("Sounds (Hit) File: ").append(hitSounds);
        sb.append(System.lineSeparator());
        sb.append("Osu Files: ").append(difficulties);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

}
