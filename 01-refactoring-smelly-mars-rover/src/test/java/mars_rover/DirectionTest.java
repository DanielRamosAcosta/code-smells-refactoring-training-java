package mars_rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void test_create_direction_from_encoding(){
        assertEquals(Direction.N, Direction.fromEncoding("N"));
        assertEquals(Direction.S, Direction.fromEncoding("S"));
        assertEquals(Direction.E, Direction.fromEncoding("E"));
        assertEquals(Direction.W, Direction.fromEncoding("W"));
    }
}