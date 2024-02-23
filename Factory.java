import src.CarRepairShop;
import src.Saab95;
import src.Scania;
import src.Volvo240;

public class Factory {
    public static VehicleObject createVolvo(double x, double y){
        Volvo240 volvo = new Volvo240();
        volvo.setLocation(x,y);
        return new VehicleObject(volvo);
    }
    public static VehicleObject createSaab(double x, double y){
        Saab95 saab = new Saab95();
        saab.setLocation(x,y);
        return new VehicleObject(saab, saab);
    }
    public static VehicleObject createScania(double x, double y){
        Scania scania = new Scania();
        scania.setLocation(x,y);
        return new VehicleObject(scania, scania);
    }
    public static CarRepairShop<Volvo240> createVolvoShop(int capacity, double x, double y){
        return new CarRepairShop<>(capacity, x, y);
    }
}
