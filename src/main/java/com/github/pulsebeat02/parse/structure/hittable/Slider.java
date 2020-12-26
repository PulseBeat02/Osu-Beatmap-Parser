package com.github.pulsebeat02.parse.structure.hittable;

import com.github.pulsebeat02.throwable.MinecraftBeatmapParseException;

import java.util.List;

public class Slider extends Hittable {

    private final CurveType type;
    private final List<CurvePoint> points;
    private final int slides;
    private final double length;
    private final List<Integer> edgeSounds;
    private final List<String> edgeSets;

    public Slider(final CurveType type, final List<CurvePoint> points,
                  final int slides, final double length, final List<Integer> edgeSounds,
                  final List<String> edgeSets) {
        super("Slider", true);
        this.type = type;
        this.points = points;
        this.slides = slides;
        this.length = length;
        this.edgeSounds = edgeSounds;
        this.edgeSets = edgeSets;
    }

    public CurveType getType() {
        return type;
    }

    public List<CurvePoint> getPoints() {
        return points;
    }

    public int getSlides() {
        return slides;
    }

    public double getLength() {
        return length;
    }

    public List<Integer> getEdgeSounds() {
        return edgeSounds;
    }

    public List<String> getEdgeSets() {
        return edgeSets;
    }

    private enum CurveType {

        BEZIER('B'),
        CENTRIPETAL_CATMULL_ROM('C'),
        LINEAR('L'),
        PERFECT_CIRCLE('P');

        private final char type;

        CurveType(final char type) {
            this.type = type;
        }

        public static CurveType getCurveType(final char c) {
            for (CurveType type : CurveType.values()) {
                if (type.getType() == c) {
                    return type;
                }
            }
            throw new MinecraftBeatmapParseException("Can't find Curve Type: " + c);
        }

        public char getType() {
            return type;
        }

    }

    private class CurvePoint {

        private final int x;
        private final int y;

        public CurvePoint(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public CurvePoint(final String parse) {
            String[] split = parse.split(":");
            this.x = Integer.parseInt(split[0]);
            this.y = Integer.parseInt(split[1]);
        }

    }

}
