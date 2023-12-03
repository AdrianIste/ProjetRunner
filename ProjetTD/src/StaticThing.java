import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;


public class StaticThing {
    private ImageView imageView;
    public double sizeX; //je mets en public pour y accéder, j'aurais aussi pu passer par un getter
    private double sizeY; //j'essaye de passer par un getter pour accéder à y dans une autre class
    public StaticThing(double sizeX, double sizeY, String fileName) throws Exception {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Image image = new Image(new FileInputStream(fileName)); //on va chercher le nom de l'image
        this.imageView = new ImageView(image); //création de l'image view
        this.imageView.setFitHeight(sizeY);
        this.imageView.setFitWidth(sizeX);
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public ImageView getImageView() {

        return imageView;
    }
}
