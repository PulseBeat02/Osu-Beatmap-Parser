package com.github.pulsebeat02.parse.structure.hittable;

import com.github.pulsebeat02.throwable.BeatmapParseException;

import java.util.List;

public class HitObjectsCategory {

    private enum ObjectType {

        HIT_CIRCLE(0),
        SLIDER(1),
        NEW_COMBO(2),
        SPINNER(3),
        SKIP_ONE_COMBO(4),
        SKIP_TWO_COMBO(5),
        SKIP_THREE_COMBO(6),
        MANIA_HOLD(7);

        private final int id;

        ObjectType(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

    private enum HitSound {

        NORMAL(0),
        WHISTLE(1),
        FINISH(2),
        CLAP(3);

        private final int id;

        HitSound(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

    private static class HitSample {

        private final SetArgument normalSet;
        private final SetArgument additionSet;
        private final int index;
        private final int volume;
        private final String fileName;

        public HitSample(final int normalSet, final int additionSet,
                         final int index, final int volume,
                         final String fileName) {
            this.normalSet = SetArgument.getFromId(normalSet);
            this.additionSet = SetArgument.getFromId(additionSet);
            this.index = index;
            this.volume = volume;
            this.fileName = fileName;
        }

        private enum SetArgument {

            NONE(0),
            NORMAL(1),
            SOFT(2),
            DRUM(3);

            private final int id;

            SetArgument(final int id) {
                this.id = id;
            }

            public static SetArgument getFromId(final int id) {
                for (SetArgument arg : SetArgument.values()) {
                    if (arg.getId() == id) {
                        return arg;
                    }
                }
                throw new BeatmapParseException("Could not parse NormalSet/AdditionSet ID");
            }

            public int getId() {
                return id;
            }

        }

    }

    private class HitObject {

        private final int x;
        private final int y;
        private final int time;
        private final ObjectType type;
        private final HitSound sound;
        private final Hittable objectParams;
        private final List<HitSample> hitSamples;

        public HitObject(final int x, final int y, final int time,
                         final ObjectType type, final HitSound sound,
                         final Hittable objectParams, final List<HitSample> hitSamples) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
            this.sound = sound;
            this.objectParams = objectParams;
            this.hitSamples = hitSamples;
        }

    }

}
