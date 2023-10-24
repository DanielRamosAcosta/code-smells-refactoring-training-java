package mars_rover;

public enum Direction {
    N, S, E, W;

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
}
