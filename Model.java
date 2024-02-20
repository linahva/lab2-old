import java.util.ArrayList;

public class Model {
    private ArrayList<VehicleObject> vehicles;
    private ArrayList<ShopObject> shops;
    private CarView view;

    public Model(CarView view) {
        this.view = view;
        this.vehicles = new ArrayList<>();
        this.shops = new ArrayList<>();
    }

    public void addVehicle(VehicleObject vehicle) {
        vehicles.add(vehicle);
    }

    public void addShop(ShopObject shop) {
        shops.add(shop);
    }

    public void updateCarView() {
        for (VehicleObject vehicle : vehicles) {
            view.drawPanel.addItems(new VehicleObject(vehicle.getVehicle()));
        }
        for (ShopObject shop : shops) {
            view.drawPanel.addItems(new ShopObject(shop.getShop()));
        }
        //view.drawPanel.repaint();
    }
}


