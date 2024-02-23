import java.util.ArrayList;

/**
 * IModelObserver
 */
public interface IModelObserver {
    public void onModelUpdate();
    public void addRenderItem(ImageWrapper item);
    public void removeRenderItem(ImageWrapper item);
}