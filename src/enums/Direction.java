package enums;

public enum Direction {
    NORTH {
        @Override
        public Direction before() {
            return values()[3];
        }

        @Override
        public String toString() {
            return "N";
        }
    },
    EAST {
        @Override
        public String toString() {
            return "E";
        }
    },
    SOUTH {
        @Override
        public String toString() {
            return "S";
        }
    },
    WEST {
        @Override
        public Direction next() {
            return values()[0];
        }

        @Override
        public String toString() {
            return "W";
        }
    };

    public Direction next() {
        return values()[ordinal() + 1];
    }

    public Direction before() {
        return values()[ordinal() - 1];
    }
}
