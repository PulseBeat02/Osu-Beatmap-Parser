package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;

import java.io.IOException;
import java.util.Map;

public class ColoursCategory extends CommaSeparatedValueFactory {

    private final Map<Integer, Colour> comboColour;
    private final Colour sliderTrackColour;
    private final Colour sliderBorderColour;

    public ColoursCategory(final OsuFile file, final Map<Integer, Colour> comboColour,
                           final Colour sliderTrackColour, final Colour sliderBorderColour) throws IOException {
        super("Colours", file, ColoursCategory.class);
        this.comboColour = comboColour;
        this.sliderTrackColour = sliderTrackColour;
        this.sliderBorderColour = sliderBorderColour;
    }

    public Map<Integer, Colour> getComboColour() {
        return comboColour;
    }

    public Colour getSliderTrackColour() {
        return sliderTrackColour;
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

}
