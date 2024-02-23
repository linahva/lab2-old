import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.CarRepairShop;
import src.Vehicle;
import src.Volvo240;

public class ShopObject extends ImageWrapper{
    private CarRepairShop<Volvo240> shop;

    ShopObject(CarRepairShop<Volvo240> shop){
        this.shop = shop;
        this.position = new Point();
        this.position.x = (int) this.shop.shopX();
        this.position.y = (int) this.shop.shopY();
        try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public CarRepairShop<Volvo240> getShop() {
        return shop;
    }
    public boolean loadable(Vehicle vehicle){
        return shop.loadable(vehicle);
    }
    public void loadCar(Volvo240 car) {
        shop.loadCar(car);
    }
}