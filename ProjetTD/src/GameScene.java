import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class GameScene extends Scene {
  private Camera camera;
  private StaticThing staticThingLeft;
  private StaticThing staticThingRight;

    public GameScene(Pane pane,double width, double height, Camera camera) throws Exception {
        super(pane,width,height);
        this.camera = camera;
        //this.staticThingLeft=StaticThingLeft;//on initialise le background
        //this.staticThingRight=StaticThingRight;
        StaticThing StaticThingLeft=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");
        StaticThing StaticThingRight=new StaticThing(600,500,"C:\\Users\\istea\\Downloads\\desert.png");

        pane.getChildren().add(StaticThingLeft.getImageView());
        pane.getChildren().add(StaticThingRight.getImageView()); // pour ajouter les background au "pane", c'est lui qui contient ce qu'il faut afficher
        StaticThingRight.getImageView().setLayoutX(StaticThingLeft.getImageView().getImage().getWidth());// pour mettre les deux images côte à côte
        StaticThingRight.getImageView().setLayoutY(0);
        render (StaticThingLeft,StaticThingRight);// pour modifier le background selon la position de la camera dans grace a render
    }
    public void render (StaticThing staticThingLeft, StaticThing staticThingRight) {
        staticThingLeft.getImageView().setLayoutX(-camera.getX());
        staticThingLeft.getImageView().setLayoutY(-camera.getY());

        staticThingRight.getImageView().setLayoutX(-camera.getX() + staticThingLeft.getImageView().getImage().getWidth());
        staticThingRight.getImageView().setLayoutY(-camera.getY());

        if (camera.getX() > staticThingRight.sizeX+staticThingLeft.sizeX) {
            staticThingLeft.getImageView().setLayoutX(staticThingRight.getImageView().getLayoutX()+staticThingRight.getImageView().getImage().getWidth());
        }
        if (camera.getX()) { // à finir pour le positionnement du background de gauche à droite.
            staticThingRight.getImageView().setLayoutX(staticThingLeft.getImageView().getImage().getWidth());
        }

    }




    public StaticThing getstaticThingLeft() {
        return staticThingLeft;
    }

    public StaticThing getstaticThingRight() {
        return staticThingRight;
    }



    //  public void setImageView(fileName) {    }
   // StaticThing StaticThingLeft=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");
    //StaticThing StaticThingRight=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");

}



