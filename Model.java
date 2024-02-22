import src.CarRepairShop;
import src.Saab95;
import src.Scania;
import src.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {
    private ArrayList<VehicleObject> vehicles;
    private ShopObject shop;
    private CarView view;

    public Model(CarView view) {
        this.view = view;
        this.vehicles = new ArrayList<>();
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        saab.setLocation(0,100);
        scania.setLocation(0,200);
        this.addVehicle(new VehicleObject(volvo));
        this.addVehicle(new VehicleObject(saab));
        this.addVehicle(new VehicleObject(scania));
        this.shop = new ShopObject(new CarRepairShop<Volvo240>(3,300,0));
        updateCarView();
    }

    public void addVehicle(VehicleObject vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<VehicleObject> getVehicles() {
        return vehicles;
    }
    public ShopObject getShop() {
        return shop;
    }



    public void addShop (ShopObject shop){
        this.shop=shop;
    }

    public void updateCarView () {
        for (VehicleObject vehicle : vehicles) {
            view.drawPanel.addItems(vehicle);
        }
        //for (ShopObject shop : shop) {
            view.drawPanel.addItems(shop);
        //}
        //view.drawPanel.repaint();
    }


        public void updateTickModel() {
            for (VehicleObject vehicle : vehicles) {
                vehicle.getVehicle().move();
                vehicle.moveit();
                if (vehicle.getVehicle() instanceof Volvo240 && getShop().getShop().loadable((Volvo240) vehicle.getVehicle())) {
                    getShop().getShop().loadCar((Volvo240) vehicle.getVehicle());
            }
                checkInBounds(800, 800);
                view.repaint();
        }
    }
    public void checkInBounds(int x, int y){
        for (VehicleObject car : vehicles) {
            if (car.getVehicle().getX()>x-100 || car.getVehicle().getX()<0 || car.getVehicle().getY()>y+200 || car.getVehicle().getY()<-5) {
                car.getVehicle().flipDirection();
            }
        }
    }

}


