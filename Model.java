import src.CarRepairShop;
import src.IPlatform;
import src.ITurbo;
import src.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.Timer;

public class Model {
    private ArrayList<VehicleObject> vehicles;
    private ShopObject shop;
    private ArrayList<IModelObserver> observers = new ArrayList<IModelObserver>();
    private final int delay = 50;
    private Timer timer;

    public Model() {
        vehicles = new ArrayList<>();
        timer = new Timer(delay, new TimerListener());
        initObjects();
        startTimer();
    }
    public void initObjects(){
        addVehicle(Factory.createSaab(0, 200,false));
        addVehicle(Factory.createVolvo(0, 0,false));
        addVehicle(Factory.createScania(0, 400,false));
        addShop(Factory.createVolvoShop(10, 200, 0));
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateTickModel();
        }
    }
    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void addVehicle(VehicleObject vehicle) {
        if (vehicles.size() < 10){
        vehicles.add(vehicle);
        notifyObservers();
        }
    }
    public void removeVehicle() { 
        if (vehicles.size() > 0){
            vehicles.remove(0);
            notifyObservers();
        }
    }
    public ArrayList<IDrawable> getDrawables(){
        ArrayList<IDrawable> drawables = new ArrayList<>();
        for (VehicleObject vehicle : vehicles) {
            drawables.add(vehicle);
        }
        drawables.add(shop);
        return drawables;
    }

    public ShopObject getShop() {
        return shop;
    }

    public void addShop (CarRepairShop<Volvo240> shop){
        this.shop = new ShopObject(shop);
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
            if (vehicle.getVehicle() instanceof ITurbo){
            vehicle.setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (VehicleObject vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof ITurbo){
            vehicle.setTurboOff();
            }
        }
    }
    public void liftPlatform() {
        for (VehicleObject vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof IPlatform){
            vehicle.raisePlatform();
            }
        }
    }
    public void lowerPlatform() {
        for (VehicleObject vehicle : vehicles) {
            if (vehicle.getVehicle() instanceof IPlatform){
            vehicle.lowerPlatform();
            }
        }
    }
    //Random implementation av addCar då inget mer specifikt definerades
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


