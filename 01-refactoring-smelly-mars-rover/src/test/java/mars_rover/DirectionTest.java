package mars_rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void test_create_direction_from_encoding(){
        assertEquals(Direction.N, Direction.create("N"));
        assertEquals(Direction.S, Direction.create("S"));
        assertEquals(Direction.E, Direction.create("E"));
        assertEquals(Direction.W, Direction.create("W"));
    }
}