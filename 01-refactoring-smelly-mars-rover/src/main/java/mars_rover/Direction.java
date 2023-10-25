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

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongYAxis(displacement);
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

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongYAxis(-displacement);
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

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongXAxis(displacement);
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

        @Override
        public Coordinate move(Coordinate coordinate, int displacement) {
            return coordinate.moveAlongXAxis(-displacement);
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

    public abstract Direction rotateLeft();

    public abstract Direction rotateRight();

    public abstract Coordinate move(Coordinate coordinate, int displacement);
}
