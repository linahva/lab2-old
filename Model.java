import src.CarRepairShop;
import src.Volvo240;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private ArrayList<VehicleObject> vehicles;
    private ShopObject shop;
    private ArrayList<IModelObserver> observers = new ArrayList<IModelObserver>();

    public Model() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(VehicleObject vehicle) {
        if (vehicles.size() < 10){
        vehicles.add(vehicle);
        addRenderToObserver(vehicle);
        notifyObservers();
        }
    }
    public void removeVehicle() { 
        if (vehicles.size() > 0){
            removeRenderFromObserver(vehicles.get(0));
            vehicles.remove(0);
            notifyObservers();
        }
    }
    public void addRenderToObserver(ImageWrapper img) {
        for (IModelObserver observer : observers) {
            observer.addRenderItem(img);
        }
    }
    public void removeRenderFromObserver(ImageWrapper img) {
        for (IModelObserver observer : observers) {
            observer.removeRenderItem(img);
        }
    }

    public ShopObject getShop() {
        return shop;
    }

    public void addShop (CarRepairShop<Volvo240> shop){
        this.shop = new ShopObject(shop);
        addRenderToObserver(this.shop);
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    public void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject vehicle : vehicles) {
            vehicle.brake(gas);
        }
    }
    public void startEngine() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.startEngine();
        }
    }
    public void stopEngine() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
    public void turboOn() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.setTurboOn();
        }
    }
    public void turboOff() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.setTurboOff();
        }
    }
    public void liftPlatform() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.raisePlatform();
        }
    }
    public void lowerPlatform() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.lowerPlatform();
        }
    }
    public void addCar() {
        addVehicle(Factory.createVolvo(400, 300, true));
    }
    public void removeCar() {
        removeVehicle();
    }
    public void addObserver(IModelObserver observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for (IModelObserver observer : observers) {
            observer.onModelUpdate();
        }
    }

    public void updateTickModel() {
        for (VehicleObject vehicle : vehicles) {
            vehicle.move();
            tryLoading(vehicle);
            checkInBounds(vehicle, 800, 800);
            notifyObservers();
        }
    }
    public void tryLoading(VehicleObject vehicle) {
        if (vehicle.getVehicle() instanceof Volvo240 && getShop().loadable(vehicle.getVehicle())) {
            getShop().loadCar((Volvo240) vehicle.getVehicle());
        }
    }
    public void checkInBounds(VehicleObject v, int x, int y){
            if (v.getX()>x-100 || v.getX()<0 || v.getY()>y+200 || v.getY()<-5) {
                v.flipDirection();
            
        }
    }

}


