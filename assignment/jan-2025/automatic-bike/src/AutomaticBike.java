public class AutomaticBike {
    private boolean powerStatus;
    private float speed;
    private int gear;

    public AutomaticBike() {
        this.powerStatus = false;
        this.speed = 0;
        this.gear = 1;
    }

    public boolean getPowerStatus() {
        return powerStatus;
    }

    public boolean exist() {
        return true;
    }

    public void turnOn() {
        this.powerStatus = true;
    }

    public void turnOff() {
        this.powerStatus = false;
    }

    public float getSpeed() {
        return this.speed;
    }
    private void setSpeed(float speed) {
        if (speed >= 0) {
            this.speed = speed;
            changeGear();
        }
    }

    public int getGear() {
        return this.gear;
    }

    private void changeGear() {
        if (speed <= 20)
            gear = 1;
        else if (speed <= 30)
            gear = 2;
        else if (speed <= 40)
            gear = 3;
        else if (speed >= 41)
            gear = 4;
    }

    public void accelerate() {
        switch (gear) {
            case 1 -> setSpeed(speed + 1);
            case 2 -> setSpeed(speed + 2);
            case 3 -> setSpeed(speed + 3);
            case 4 -> setSpeed(speed + 4);
        }
    }

    public void decelerate() {
        switch (gear) {
            case 1 -> setSpeed(speed - 1);
            case 2 -> setSpeed(speed - 2);
            case 3 -> setSpeed(speed - 3);
            case 4 -> setSpeed(speed - 4);
        }
    }
}
