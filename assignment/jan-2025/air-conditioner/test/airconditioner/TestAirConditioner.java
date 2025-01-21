package airconditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestAirConditioner {
    AirConditioner airConditioner;
    final int MAX_TEMPERATURE = 30;
    final int MIN_TEMPERATURE = 16;

    @BeforeEach
    void setUp() {
        airConditioner = new AirConditioner();
    }

    @Test
    public void testAirConditioner_Exist(){
        assertNotNull(airConditioner);
    }

    @Test
    public void testAirConditioner_InitialStateIsCorrect(){
        assertEquals(AirConditioner.PowerState.OFF, airConditioner.getPowerState());
        assertEquals(airConditioner.getTemperature(), airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_CanBeTurnedOn(){
        assertEquals(AirConditioner.PowerState.OFF, airConditioner.getPowerState());
        airConditioner.turnOn();
        assertEquals(AirConditioner.PowerState.ON, airConditioner.getPowerState());
    }

    @Test
    public void TestAirConditioner_CanBeTurnedOff(){
        airConditioner.turnOn();
        assertEquals(AirConditioner.PowerState.ON, airConditioner.getPowerState());
        airConditioner.turnOff();
        assertEquals(AirConditioner.PowerState.OFF, airConditioner.getPowerState());
    }

    @Test
    public void TestAirConditioner_CanIncreaseTemperature(){
        airConditioner.turnOn();
        int temperature = airConditioner.getTemperature();
        airConditioner.increaseTemperature();
        assertEquals((temperature + 1), airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_CanDecreaseTemperature(){
        airConditioner.turnOn();
        int temperature = airConditioner.getTemperature();
        airConditioner.decreaseTemperature();
        assertEquals((temperature - 1), airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_DoesNotIncreaseBeyond30Degrees(){
        airConditioner.turnOn();
        IntStream.rangeClosed(1, 40).forEach(_ -> airConditioner.increaseTemperature());
        assertEquals(MAX_TEMPERATURE, airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_DoesNotDecreaseBelow16Degrees(){
        airConditioner.turnOff();
        int initialTemperature = airConditioner.getTemperature();
        airConditioner.decreaseTemperature();
        int finalTemperature = airConditioner.getTemperature();
        assertEquals(initialTemperature, finalTemperature);
    }

    @Test
    public void TestAirConditioner_DoesNotIncreaseWhenOff(){
        airConditioner.turnOff();
        int initialTemperature = airConditioner.getTemperature();
        airConditioner.increaseTemperature();
        int finalTemperature = airConditioner.getTemperature();
        assertEquals(initialTemperature, finalTemperature);
    }

}
