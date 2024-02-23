import java.util.Random;

import src.CarRepairShop;
import src.Saab95;
import src.Scania;
import src.Volvo240;

public class Factory {
    private static double randomAngle(boolean randomAngle){
        if (randomAngle){
        return new Random().nextDouble() * (2 * Math.PI);
        } else {
            return 0;
        }
    }
    public static VehicleObject createVolvo(double x, double y, boolean randomAngle){
        Volvo240 volvo = new Volvo240();
        volvo.setLocation(x,y);
        volvo.setAngle(randomAngle(randomAngle));
        return new VehicleObject(volvo);
    }
    public static VehicleObject createSaab(double x, double y, boolean randomAngle){
        Saab95 saab = new Saab95();
        saab.setLocation(x,y);
        saab.setAngle(randomAngle(randomAngle));
        return new VehicleObject(saab, saab);
    }
    public static VehicleObject createScania(double x, double y, boolean randomAngle){
        Scania scania = new Scania();
        scania.setLocation(x,y);
        scania.setAngle(randomAngle(randomAngle));
        return new VehicleObject(scania, scania);
    }
    public static CarRepairShop<Volvo240> createVolvoShop(int capacity, double x, double y){
        return new CarRepairShop<>(capacity, x, y);
    }
}
