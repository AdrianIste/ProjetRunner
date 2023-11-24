import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;


public class StaticThing {
    private ImageView imageView;
    private double sizeX;
    private double sizeY;
    public StaticThing(double sizeX, double sizeY, String fileName) throws Exception {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Image image = new Image(new FileInputStream(fileName));
        this.imageView = new ImageView(image);
    }

    public ImageView getImageSet() {
        return imageView;
    }
}
