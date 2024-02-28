import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class View extends JPanel implements IModelObserver{

    private Model model;
    private ArrayList<IDrawable> items = new ArrayList<IDrawable>();


    public void onModelUpdate() {
        items = model.getDrawables();
        this.repaint();
    }

    // Initializes the panel and reads the images
    public View(int x, int y, Model model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawable item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), null);
        }
    }
}
