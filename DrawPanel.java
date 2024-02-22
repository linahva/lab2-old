import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ArrayList<ImageWrapper> items = new ArrayList<>();


    //
    void addItems(ImageWrapper item) {
        items.add(item);
    }
    void removeItems(ImageWrapper item) {
        items.remove(item);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
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
