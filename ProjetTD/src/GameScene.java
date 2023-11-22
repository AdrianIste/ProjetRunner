import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
  private Camera camera;

    public GameScene(Pane pane,Width width, Height height, Camera camera) {
        super(pane,width,height);
        this.camera = camera;
    }
}

}

