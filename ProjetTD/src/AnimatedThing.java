import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public abstract class AnimatedThing {
    private double x,y;
    private ImageView Sheet;
    private int action;

    public int index;
    private int duration;
    private int max;
    private int windowSizex;
    private int windowSizey;
    private int offset;

    public AnimatedThing(double x, double y, int action, int index, int duration, int max, int windowSizex,int windowSizey, int offset, String fileName) throws Exception {
        this.action = action;
        this.index = index;
        this.duration = duration;
        this.max = max;
        this.windowSizex = windowSizex;
        this.windowSizey = windowSizey;
        this.offset = offset;
        this.x=x;
        this.y=y;

        Image image = new Image(new FileInputStream(fileName));
        Sheet=new ImageView(image);
        Sheet.setLayoutX(x);
        Sheet.setLayoutY(y);
        updateViewport();
    }

    public ImageView getSheet() {
        return Sheet;
    }
    void updateViewport() {
        double offx = index * offset; // Décalage horizontal en fonction de l'index
        double offy= action * windowSizey; // Décalage vertical en fonction de l'attitude et de la taille de la fenêtre

        // Définir la zone de vue en fonction des décalages calculés
        Sheet.setViewport(new Rectangle2D(offx, offy,windowSizex, windowSizey)); // pour voir une partie de l'image


    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return x;
    }
}


