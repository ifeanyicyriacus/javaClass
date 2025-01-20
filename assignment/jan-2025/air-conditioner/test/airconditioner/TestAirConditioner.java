package airconditioner;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestAirConditioner {
    @Test
    public void testAirConditioner_Exist(){
        AirConditioner airConditioner = new AirConditioner();
    }

    @Test
    public void TestAirConditioner_CanBeTurnedOn(){
        AirConditioner airConditioner = new AirConditioner();
        assertEquals(AirConditioner.PowerState.OFF, airConditioner.getPowerState());
        airConditioner.turnOn();
        assertEquals(AirConditioner.PowerState.ON, airConditioner.getPowerState());
    }

    @Test
    public void TestAirConditioner_CanBeTurnedOff(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        assertEquals(AirConditioner.PowerState.ON, airConditioner.getPowerState());
        airConditioner.turnOff();
        assertEquals(AirConditioner.PowerState.OFF, airConditioner.getPowerState());
    }

    @Test
    public void TestAirConditioner_CanIncreaseTemperature(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        int temperature = airConditioner.getTemperature();
        airConditioner.increaseTemperature();
        assertEquals((temperature + 1), airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_CanDecreaseTemperature(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        int temperature = airConditioner.getTemperature();
        airConditioner.decreaseTemperature();
        assertEquals((temperature - 1), airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_DoesNotIncreaseBeyond30Degrees(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        final int MAX_TEMPERATURE = 30;
        IntStream.rangeClosed(1, 40).forEach(_ -> airConditioner.increaseTemperature());
        assertEquals(MAX_TEMPERATURE, airConditioner.getTemperature());
    }

    @Test
    public void TestAirConditioner_DoesNotDecreaseBelow16Degrees(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOff();
        final int MIN_TEMPERATURE = 16;
        IntStream.rangeClosed(1, 40).forEach(_ -> airConditioner.decreaseTemperature());
        assertEquals(MIN_TEMPERATURE, airConditioner.getTemperature());
    }
}
