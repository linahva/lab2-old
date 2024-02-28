public class MainApp {

    public static void main(String[] args) {
        Model model = new Model();
        CarController cc = new CarController(model);
        View view = new View(800, 560, model);
        Widget cw = new Widget("Car", cc, view);
        model.addObserver(view);
    }
}

