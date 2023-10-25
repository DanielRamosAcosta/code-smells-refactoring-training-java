package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.create("W");
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return Direction.create("E");
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return Direction.create("N");
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return Direction.create("S");
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
}
