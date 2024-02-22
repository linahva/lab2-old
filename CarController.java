
import src.CarRepairShop;
import src.Volvo240;
import src.Saab95;
import src.Scania;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private MainTimer timer;

    // The frame that represents this instance View of the MVC pattern
    private Model model;


    public CarController(CarView view) {
        this.model = new Model(view);
    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public void updateTickModel() {
        model.updateTickModel();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;for (VehicleObject car : model.getVehicles()
                ) {
            car.getVehicle().gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;for (VehicleObject car : model.getVehicles()
        ) {
            car.getVehicle().brake(brake);
        }
    }
    void startCars() {
        for (VehicleObject car : model.getVehicles())
            car.getVehicle().startEngine();
    }
    void stopCars() {
        for (VehicleObject car : model.getVehicles())
            car.getVehicle().stopEngine();
    }
    void turboOn() {
        Saab95 saab;
        for (VehicleObject car : model.getVehicles()) {
            if (car.getVehicle() instanceof Saab95) {
                saab = (Saab95) car.getVehicle();
                saab.setTurboOn();
            }
        }
    }
    void turboOff() {
        Saab95 saab;
        for (VehicleObject car : model.getVehicles()) {
            if (car.getVehicle() instanceof Saab95) {
                saab = (Saab95) car.getVehicle();
                saab.setTurboOff();
            }
        }
    }
    void liftPlatform() {
        Scania scania;
        for (VehicleObject car : model.getVehicles()) {
            if (car.getVehicle() instanceof Scania) {
                scania = (Scania) car.getVehicle();
                scania.raisePlatform();
            }
        }
    }
    void lowerPlatform() {
        Scania scania;
        for (VehicleObject car : model.getVehicles()) {
            if (car.getVehicle() instanceof Scania) {
                scania = (Scania) car.getVehicle();
                scania.lowerPlatform();
            }
        }
    }

}
