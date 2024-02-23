
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    private Model model;


    public CarController(Model model) {
        this.model = model;
    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
            model.gas(gas);
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
            model.brake(brake);
    }
    void startCars() {
        model.startEngine();
    }
    void stopCars() {
        model.stopEngine();
    }
    void turboOn() {
        model.turboOn();
    }
    void turboOff() {
        model.turboOff();
    }
    void liftPlatform() {
        model.liftPlatform();
    }
    void lowerPlatform() {
        model.lowerPlatform();
    }

}
