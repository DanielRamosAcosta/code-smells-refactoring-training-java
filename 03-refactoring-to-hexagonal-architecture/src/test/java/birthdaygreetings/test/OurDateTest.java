package birthdaygreetings.test;

import static org.junit.jupiter.api.Assertions.*;

import birthdaygreetings.OurDate;

import org.junit.jupiter.api.Test;

public class OurDateTest {
    @Test
    public void getters() throws Exception {
        OurDate ourDate = OurDate.createOurDate("1789/01/24");
        assertEquals(1, ourDate.getMonth());
        assertEquals(24, ourDate.getDay());
    }

    @Test
    public void isSameDate() throws Exception {
        OurDate ourDate = OurDate.createOurDate("1789/01/24");
        OurDate sameDay = OurDate.createOurDate("2001/01/24");
        OurDate notSameDay = OurDate.createOurDate("1789/01/25");
        OurDate notSameMonth = OurDate.createOurDate("1789/02/25");

        assertTrue(ourDate.isSameDay(sameDay), "same");
        assertFalse(ourDate.isSameDay(notSameDay), "not same day");
        assertFalse(ourDate.isSameDay(notSameMonth), "not same month");
    }

    @Test
    public void equality() throws Exception {
        OurDate base = OurDate.createOurDate("2000/01/02");
        OurDate same = OurDate.createOurDate("2000/01/02");
        OurDate different = OurDate.createOurDate("2000/01/04");

        assertNotEquals(null, base);
        assertEquals(base, base);
        assertEquals(base, same);
        assertNotEquals(base, different);
    }
}
