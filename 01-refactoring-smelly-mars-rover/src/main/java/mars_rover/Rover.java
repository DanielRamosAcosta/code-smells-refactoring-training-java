package mars_rover;
import java.util.Objects;

public class Rover {

    private Direction direction;

    private Coordinate coordinate;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        coordinate = new Coordinate(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                direction = direction.rotateLeft();
            } else if (command.equals("r")) {

                // Rotate Rover right
                if (direction.isFacingNorth()) {
                    this.direction = Direction.create("E");
                } else if (direction.isFacingSouth()) {
                    this.direction = Direction.create("W");
                } else if (direction.isFacingWest()) {
                    this.direction = Direction.create("N");
                } else {
                    this.direction = Direction.create("S");
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (direction.isFacingNorth()) {
                    coordinate = coordinate.moveAlongYAxis(displacement);
                } else if (direction.isFacingSouth()) {
                    coordinate = coordinate.moveAlongYAxis(-displacement);
                } else if (direction.isFacingWest()) {
                    coordinate = coordinate.moveAlongXAxis(-displacement);
                } else {
                    coordinate = coordinate.moveAlongXAxis(displacement);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction && Objects.equals(coordinate, rover.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinate);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", coordinate=" + coordinate +
                '}';
    }

}
