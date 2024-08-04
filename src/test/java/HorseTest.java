import lombok.SneakyThrows;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ToString
class HorseTest {

    private final String name = "Bucephalus";
    private final double speed = 10;
    private final double distance = 1000;


    @Test
    @DisplayName("Mytest")
    void testConstructor_ShouldException_WhenFirstParametrNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Horse(null, 100));
    }

    @Test
    void testContructor_ShouldMessage_WhenFirsrParametrNull() {

        String expectedMassage = "Name cannot be null.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 100));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\r", "\n", "\f"})
    void testContructor_ShouldException_WhenArgNameIsSpecialSymbols(String name) {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, 100));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\r", "\n", "\f"})
    void testContructor_ShouldMessage_WhenArgNameIsSpecialSymbols(String name) {

        String expectedMassage = "Name cannot be blank.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 100));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);
    }

    @Test
    void testContructor_ShouldExeption_WhenArgSpeedNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, -speed));
    }

    @Test
    void testContructor_ShouldMessage_WhenArgSpeedNegative() {

        String expectedMassage = "Speed cannot be negative.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, -speed));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);
    }

    @Test
    void testContructor_ShouldExeption_WhenThirdParametrsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, speed, -distance));
    }

    @Test
    void testContructor_ShouldMessage_WhenThirdParametrsNegative() {

        String expectedMassage = "Distance cannot be negative.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, -distance));
        String actualMessage = exception.getMessage();

        assertEquals(expectedMassage, actualMessage);
    }

    @Test
    void testGetName_ShouldReturnName_WhenArgInConstructorIsName() {
        assertEquals("Bucephalus", new Horse(name, speed, distance).getName());
    }

    @Test
    @SneakyThrows
    void testGetName_ShouldReturnName_WhenArgInConstructorIsName_UseReflection() {

        String expectedName = "Bucephalus";

        Horse horse = new Horse(name, speed);
        Field field = horse.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String actualName = (String) field.get(horse);

        assertEquals(expectedName, actualName);
    }

    @Test
    void testSpeed_ShouldReturnSpeed_WhenArgInConstructorIsSpeed() {
        assertEquals(10, new Horse(name, speed, distance).getSpeed());
    }

    @Test
    @SneakyThrows
    void testGetSpeed_ShouldReturnSpeed_WhenArgInConstructorIsSpeed_UseReflection() {

        double expectedSpeed = 10;

        Horse horse = new Horse(name, speed);
        Field field = horse.getClass().getDeclaredField("speed");
        field.setAccessible(true);
        Double actualSpeed = (Double) field.get(horse);

        assertEquals(expectedSpeed, actualSpeed);
    }


    @Test
    void testDistance_ShouldReturnDistance_WhenArgInConstructorIsDistance() {
        assertEquals(1000, new Horse(name, speed, distance).getDistance());
    }

    @Test
    @SneakyThrows
    void testGetDistanceE_ShouldReturnDistance_WhenArgInConstructorIsDisnance_UseReflection() {

        double expectedDistance = 1000;

        Horse horse = new Horse(name, speed, distance);
        Field field = horse.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        Double actualSpeed = (Double) field.get(horse);

        assertEquals(expectedDistance, actualSpeed);
    }

    @Test
    @SneakyThrows
    void test() {

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {

            Horse horse = new Horse(name, speed, distance);
            horse.move();

            mockedStatic.verify(() -> Horse.getRandomDouble(ArgumentMatchers.eq(0.2), ArgumentMatchers.eq(0.9)));
        }

    }


}
//test{Method}_Should{Do}_When{Condition}