import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.Vehicle;

public class VehicleObject extends ImageWrapper{
    private Vehicle vehicle;

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
    public void moveit(){
        position.x = (int) vehicle.getX();
        position.y = (int) vehicle.getY();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
