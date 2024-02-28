import java.awt.image.BufferedImage;

public interface IDrawable {
    public void setPosition(int x, int y);
    public int getX();
    public int getY();
    public BufferedImage getImage();
}
