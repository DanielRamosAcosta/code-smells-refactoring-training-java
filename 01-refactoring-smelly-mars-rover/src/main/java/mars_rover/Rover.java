package mars_rover;
import java.util.List;
import java.util.Objects;

public class Rover {

    public static final int DISPLACEMENT = 1;
    private Direction direction;

    private Coordinate coordinate;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        coordinate = new Coordinate(x, y);
    }

    public void receive(String commandsSequence) {
        final List<String> commands = extractCommands(commandsSequence);
        commands.forEach(this::execute);
    }

    private static List<String> extractCommands(String commandsSequence) {
        if (commandsSequence.isEmpty()) {
            return List.of();
        }
        return List.of(commandsSequence.split(""));
    }

    private void execute(String command) {
        if (command.equals("l")) {
            direction = direction.rotateLeft();
        } else if (command.equals("r")) {
            direction = direction.rotateRight();
        } else if (command.equals("f")) {
            coordinate = direction.move(coordinate, DISPLACEMENT);
        } else {
            coordinate = direction.move(coordinate, -DISPLACEMENT);
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
