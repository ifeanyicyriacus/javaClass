import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAutomaticBike {
    AutomaticBike automaticBike;

    @BeforeEach
    void setUp() {
        automaticBike = new AutomaticBike();
    }

    @Test
    public void testAutomaticBike_exist() {
        assertTrue(automaticBike.exist());
    }

    @Test
    public void testAutomaticBike_canBeTurnedOn() {
        assertTrue(automaticBike.exist());
        assertFalse(automaticBike.getPowerStatus());
        automaticBike.turnOn();
        assertTrue(automaticBike.getPowerStatus());
    }

    @Test
    public void testAutomaticBike_canBeTurnedOff() {
        assertTrue(automaticBike.exist());
        automaticBike.turnOn();
        assertTrue(automaticBike.getPowerStatus());
        automaticBike.turnOff();
        assertFalse(automaticBike.getPowerStatus());
    }

    @Test
    public void testAutomaticBike_canBeAccelerated() {
        for (int speed = 0; speed <= 200; ) {
            if (speed <= 20) speed += 1;
            else if (speed <= 30) speed += 2;
            else if (speed <= 40) speed += 3;
            else speed += 4;
            assertEquals(speed, automaticBike.getSpeed());
            automaticBike.accelerate();
        }
    }

    @Test
    public void testAutomaticBike_canBeDecelerated() {
        for (int count = 1; count < 50; count++) {
            automaticBike.accelerate();
        }
        assertTrue(automaticBike.getSpeed() > 100);
        int speed = (int) automaticBike.getSpeed();

        while (speed > 0) {
            if (speed <= 20) speed -= 1;
            else if (speed <= 30) speed -= 2;
            else if (speed <= 40) speed -= 3;
            else speed -= 4;

            automaticBike.decelerate();
            assertEquals(speed, automaticBike.getSpeed());
        }

    }
}


