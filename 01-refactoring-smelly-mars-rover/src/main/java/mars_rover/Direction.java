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
