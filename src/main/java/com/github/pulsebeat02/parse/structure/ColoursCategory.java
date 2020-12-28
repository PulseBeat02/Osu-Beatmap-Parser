package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;
import com.github.pulsebeat02.throwable.CorruptedBeatmapException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColoursCategory extends CommaSeparatedValueFactory {

    private final Map<Integer, Colour> comboColour;
    private Colour sliderTrackOverrideColour;
    private Colour sliderBorderColour;

    public ColoursCategory(final OsuFile file, final Map<Integer, Colour> comboColour,
                           final Colour sliderTrackOverrideColour, final Colour sliderBorderColour) throws IOException {
        super("Colours", file, ColoursCategory.class);
        this.comboColour = comboColour;
        this.sliderTrackOverrideColour = sliderTrackOverrideColour;
        this.sliderBorderColour = sliderBorderColour;
    }

    public Map<Integer, Colour> getComboColour() {
        return comboColour;
    }

    public Colour getSliderTrackColour() {
        return sliderTrackOverrideColour;
    }

    public Colour getSliderBorderColour() {
        return sliderBorderColour;
    }

    private class Colour {

        private final int r;
        private final int g;
        private final int b;

        public Colour(final int r, final int g, final int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }

    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        Map<Integer, Colour> comboColour = new HashMap<>();
        comboColour.put(1, new Colour(235, 22, 65));
        comboColour.put(2, new Colour(235, 165, 233));
        comboColour.put(3, new Colour(44, 205, 239));
        comboColour.put(4, new Colour(141, 236, 55));
        Set<String> possible = new HashSet<>(Arrays.asList("Combo1", "Combo2", "Combo3", "Combo4", "sliderTrackOverrideColour", "SliderBorder"));
        for (String line : contents) {
            String[] split = line.split(" ");
            if (possible.contains(split[0])) {
                try {
                    String keyword = split[0];
                    char last = keyword.charAt(keyword.length() - 1);
                    String[] rgb = split[2].split(",");
                    int r = Integer.parseInt(rgb[0]);
                    int g = Integer.parseInt(rgb[1]);
                    int b = Integer.parseInt(rgb[2]);
                    if (Character.isDigit(last)) {
                        comboColour.put(Character.getNumericValue(last), new Colour(r, g, b));
                    } else {
                        if (keyword.equals("sliderTrackOverrideColour")) {
                            sliderTrackOverrideColour = new Colour(r, g, b);
                        } else {
                            sliderBorderColour = new Colour(r, g, b);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new CorruptedBeatmapException("Corrupted Beatmap File!");
                }
            }
        }
    }

}
