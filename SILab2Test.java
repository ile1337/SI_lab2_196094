import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class SILab2Test
{
    SILab2 siLab2 = new SILab2();

    @Test
    void functionTest()
    {
        List<Integer> result = siLab2.function(Collections.singletonList(new Time( 8 , 5,  15)));
        assertEquals(Collections.singletonList(29115), result);
    }

    @Test
    void functionTestRuntimeExceptions()
    {
        HashMap<Time, String> testCases = new HashMap<>();
        testCases.put(new Time(23, 5, -16), "The seconds are not valid");
        testCases.put(new Time(-10, -10, -10), "The hours are smaller than the minimum");
        testCases.put(new Time(24, 0, 1), "The time is greater than the maximum");
        testCases.put(new Time(15, -1, 1), "The minutes are not valid!");
        testCases.put(new Time(25, -1, 1), "The hours are grater than the maximum");

        RuntimeException exception;

        for (Time time: testCases.keySet()) {
            exception = assertThrows(RuntimeException.class, () -> {
                siLab2.function(Collections.singletonList(time));
            });
            assertEquals(exception.getMessage(), testCases.get(time));
        }
    }

}