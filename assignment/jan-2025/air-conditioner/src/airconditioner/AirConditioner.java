package airconditioner;

public class AirConditioner {
    private PowerState powerState = PowerState.OFF;;
    private final int MAX_TEMPERATURE = 30;
    private final int MIN_TEMPERATURE = 16;
    private int temperature = (MAX_TEMPERATURE + MIN_TEMPERATURE) / 2;

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
        if (getPowerState() == PowerState.ON && temperature < MAX_TEMPERATURE) {
            temperature++;
        }
    }

    public void decreaseTemperature() {
        if (getPowerState() == PowerState.ON && temperature > MIN_TEMPERATURE) {
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

}
