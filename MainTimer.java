import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTimer {

    private final int delay = 50;
    private Timer timer;
    private Model model;

    public MainTimer(Model model) {
        this.model = model;
        timer = new Timer(delay, new TimerListener());
    }

    public static void main(String[] args) {
        Model model = new Model();
        CarController cc = new CarController(model);
        CarView cw = new CarView("Car", cc);
        model.addObserver(cw);
        model.addVehicle(Factory.createSaab(0, 200));
        model.addVehicle(Factory.createVolvo(0, 0));
        model.addVehicle(Factory.createScania(0, 400));
        model.addShop(Factory.createVolvoShop(10, 200, 0));
        //cw.addDrawableItems(model.getDrawableItems());
        MainTimer main = new MainTimer(model);
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

