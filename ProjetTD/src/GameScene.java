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
    }
  //  public void setImageView(fileName) {    }
    StaticThing StaticThingLeft=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");
    StaticThing StaticThingRight=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");

}



