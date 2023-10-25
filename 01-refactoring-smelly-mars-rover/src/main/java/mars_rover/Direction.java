package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.create("W");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("E");
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return Direction.create("E");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("W");
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return Direction.create("N");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("S");
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return Direction.create("S");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("N");
        }
    };

    public static Direction create(String encoding) {
        switch (encoding) {
            case "S":
                return S;
            case "E":
                return E;
            case "W":
                return W;
            default:
                return N;
        }
    }

    boolean isFacingNorth() {
        return equals(N);
    }

    boolean isFacingSouth() {
        return equals(S);
    }

    boolean isFacingWest() {
        return equals(W);
    }

    public abstract Direction rotateLeft();

    public abstract Direction rotateRight();
}
