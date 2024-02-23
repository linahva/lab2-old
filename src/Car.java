package src;

import java.awt.*;

public abstract class Car extends Vehicle{
    private ILoadedState state;
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName, 1);
        state = new LoadedStateFalse();
    }
    public void load(){
        state = new LoadedStateTrue();
    }
    public void unload(){
        state = new LoadedStateFalse();
    }
    @Override
    public void move() {
        state.action(this);
        super.move();
    }
}

