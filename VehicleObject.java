import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.IPlatform;
import src.ITurbo;
import src.Vehicle;

public class VehicleObject implements IDrawable{
    private Vehicle vehicle;
    private Point position;
    private BufferedImage image;

    public VehicleObject(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.position = new Point();
        this.position.x = (int) vehicle.getX();
        this.position.y = (int) vehicle.getY();
        try {
			this.image = ImageIO.read(View.class.getResourceAsStream("pics/"+vehicle.getModelName()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }
    public int getX() {
        return position.x;
    }
    public int getY() {
        return position.y;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setTurboOn() {
        if (vehicle instanceof ITurbo){
            ((ITurbo) vehicle).setTurboOn();
        }
    }
    public void setTurboOff() {
        if (vehicle instanceof ITurbo){
            ((ITurbo) vehicle).setTurboOn();
        }
    }
    public void raisePlatform() {
        if (vehicle instanceof IPlatform){
            ((IPlatform) vehicle).rampUp();
        }
    }
    public void lowerPlatform() {
        if (vehicle instanceof IPlatform){
            ((IPlatform) vehicle).rampDown();
        }
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
