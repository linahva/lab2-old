package src;
public class LoadedStateTrue implements ILoadedState{
    public void action(Car car){
        car.stopEngine();
    }
}
