package src;

import java.awt.*;

public abstract class Truck extends Vehicle {

    Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName, 2);
    }
    
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    @Override
    public void startEngine() {
        if (isRampDown()){
            super.startEngine();
        } else {
            throw new IllegalStateException("Cant start engine because platform is down");
        }
    }
    abstract public boolean isRampDown();
}
