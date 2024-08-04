
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class HippodromeTest {

    @Test
    void testСonstructor_ShouldException_WhenParametrIsNull() {

        assertThrows(IllegalArgumentException.class, () ->
            new Hippodrome(null));
    }

    @Test
    void testСontructor_ShouldMessage_WhenParametrIsNull() {

        String expectedMassage = "Horses cannot be null.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);
    }

    @Test
    void testСontructor_ShouldException_WhenListIsNull() {

        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(Collections.emptyList()));

    }

    @Test
    void testСontructor_ShouldMessage_WhenListIsNull() {

        String expectedMassage = "Horses cannot be empty.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Collections.emptyList()));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);

    }

    @Test
    void testgetHorses_ShoulList_WhenListIs30Horse() {

        List<Horse> horseList = IntStream.range(0, 30)
                .mapToObj(i -> new Horse("Name " + i, i, i))
                .toList();
        Hippodrome hippodrome = new Hippodrome(horseList);

        assertEquals(horseList, hippodrome.getHorses());

    }

    @Test
    void testMove_ShoulList_WhenLisе50Mok() {

        List<Horse> horseList = IntStream.range(0, 50)
                .mapToObj(i -> Mockito.mock(Horse.class))
                .toList();

        Hippodrome hippodrome = new Hippodrome(horseList);

        hippodrome.move();

        horseList.forEach(horse -> Mockito.verify(horse, Mockito.times(1)).move());

    }

    @Test
    void testMove_ShouldMaxDistance() {

        List<Horse> horseList = IntStream.range(0, 10)
                .mapToObj(i -> new Horse("Name " + i, i, i))
                .toList();
        Hippodrome hippodrome = new Hippodrome(horseList);

        assertSame(horseList.get(9),hippodrome.getWinner());
    }


}