import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class View extends JPanel implements IModelObserver{

    ArrayList<ImageWrapper> items = new ArrayList<>();


    public void onModelUpdate() {
        this.repaint();
    }
    public void addRenderItem(ImageWrapper item) {
        items.add(item);
    }
    public void removeRenderItem(ImageWrapper item) {
        items.remove(item);
    }

    // Initializes the panel and reads the images
    public View(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ImageWrapper item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), null);
        }
    }
}
