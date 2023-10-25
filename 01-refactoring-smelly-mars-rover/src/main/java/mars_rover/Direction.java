package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return W;
        }

        @Override
        public Direction rotateRight() {
            return E;
        }

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongYAxis(displacement);
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return E;
        }

        @Override
        public Direction rotateRight() {
            return W;
        }

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongYAxis(-displacement);
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return N;
        }

        @Override
        public Direction rotateRight() {
            return S;
        }

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongXAxis(displacement);
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return S;
        }

        @Override
        public Direction rotateRight() {
            return N;
        }

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongXAxis(-displacement);
        }
    };

    private static final String SOUTH_ENCODING = "S";
    private static final String EAST_ENCODING = "E";
    private static final String WEST_ENCODING = "W";

    public static Direction create(String encoding) {
        switch (encoding) {
            case SOUTH_ENCODING:
                return S;
            case EAST_ENCODING:
                return E;
            case WEST_ENCODING:
                return W;
            default:
                return N;
        }
    }

    public abstract Direction rotateLeft();

    public abstract Direction rotateRight();

    public abstract Coordinate move(Coordinate coordinate, int displacement);
}
