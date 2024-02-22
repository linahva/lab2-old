import src.CarRepairShop;
import src.Saab95;
import src.Scania;
import src.Volvo240;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainTimer {

    private final int delay = 50;
    private Timer timer;
    private CarView carView;

    public MainTimer(CarView carView) {
        this.carView = carView;
        timer = new Timer(delay, new TimerListener());
    }

    public static void main(String[] args) {
        CarView cw = new CarView("Car");
        MainTimer main = new MainTimer(cw);
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
            carView.updateTick();
            //carView.repaint(); // Repaint the CarView on each timer tick
        }
    }
}

