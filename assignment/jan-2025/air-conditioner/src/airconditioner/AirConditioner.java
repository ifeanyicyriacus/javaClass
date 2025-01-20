package airconditioner;

public class AirConditioner {
    private PowerState powerState = PowerState.OFF;
    private int temperature;
    final int MAX_TEMPERATURE;
    final int MIN_TEMPERATURE;

    public void turnOn() {
        setPowerState(PowerState.ON);
    }
    public void turnOff() {
        setPowerState(PowerState.OFF);
    }
    public int getTemperature(){
        return temperature;
    }

    public void increaseTemperature() {
        if (temperature < MAX_TEMPERATURE) {
            temperature++;
        }
    }

    public void decreaseTemperature() {
        if (temperature > MIN_TEMPERATURE) {
            temperature--;
        }
    }

    public enum PowerState {
        ON, OFF
    }

    public PowerState getPowerState() {
        return powerState;
    }
    private void setPowerState(PowerState powerState) {
        this.powerState = powerState;
    }

    public AirConditioner() {
        this.MAX_TEMPERATURE = 30;
        this.MIN_TEMPERATURE = 16;
        this.temperature = (MAX_TEMPERATURE + MIN_TEMPERATURE) / 2;
    }
}
