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
                direction = direction.rotateRight();
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                coordinate = direction.move(coordinate, displacement);
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
