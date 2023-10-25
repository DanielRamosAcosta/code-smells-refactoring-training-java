package mars_rover;
import java.util.Objects;

public class Rover {

    private Direction direction;

    private Coordinate coordinate;

    public static final int DISPLACEMENT = 1;

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
                direction = direction.rotateRight();
            } else if (command.equals("f")) {
                // Displace Rover
                coordinate = direction.move(coordinate, DISPLACEMENT);
            } else {
                // Displace Rover
                coordinate = direction.move(coordinate, -DISPLACEMENT);
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
