import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {

    private final int delay = 50;
    private Timer timer;
    private Model model;

    public MainApp(Model model) {
        this.model = model;
        timer = new Timer(delay, new TimerListener());
    }

    public static void main(String[] args) {
        Model model = new Model();
        CarController cc = new CarController(model);
        View drawPanel = new View(800, 560);
        Widget cw = new Widget("Car", cc, drawPanel);
        model.addObserver(drawPanel);
        model.addVehicle(Factory.createSaab(0, 200,false));
        model.addVehicle(Factory.createVolvo(0, 0,false));
        model.addVehicle(Factory.createScania(0, 400,false));
        model.addShop(Factory.createVolvoShop(10, 200, 0));
        //cw.addDrawableItems(model.getDrawableItems());
        MainApp main = new MainApp(model);
        main.startTimer();
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateTickModel();
            //carView.repaint(); // Repaint the CarView on each timer tick
        }
    }
}

