import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.IScaniaRamp;
import src.ITurbo;
import src.Vehicle;

public class VehicleObject extends ImageWrapper{
    private Vehicle vehicle;
    private ITurbo turbo;
    private IScaniaRamp ramp;

    public VehicleObject(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.position = new Point();
        this.position.x = (int) vehicle.getX();
        this.position.y = (int) vehicle.getY();
        try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+vehicle.getModelName()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public VehicleObject(Vehicle vehicle, ITurbo turbo) {
        this(vehicle);
        this.turbo = turbo;
    }
    public VehicleObject(Vehicle vehicle, IScaniaRamp ramp) {
        this(vehicle);
        this.ramp = ramp;
    }

    public void setTurboOn() {
        if (turbo != null)
        turbo.setTurboOn();
    }
    public void setTurboOff() {
        if (turbo != null)
        turbo.setTurboOff();
    }
    public void raisePlatform() {
        if (ramp != null)
        ramp.raisePlatform();
    }
    public void lowerPlatform() {
        if (ramp != null)
        ramp.lowerPlatform();
    }
    public void gas(double amount) {
        vehicle.gas(amount);
    }
    public void brake(double amount) {
        vehicle.brake(amount);
    }
    public void startEngine() {
        vehicle.startEngine();
    }
    public void stopEngine() {
        vehicle.stopEngine();
    }
    public void flipDirection() {
        vehicle.flipDirection();
    }

    public void moveit(){
        position.x = (int) vehicle.getX();
        position.y = (int) vehicle.getY();
    }
    public void move() {
        vehicle.move();
        moveit();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
