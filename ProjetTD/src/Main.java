import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

         @Override
 public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Hello world");
    Camera A=new Camera(1,1);



    Image spriteSheet = new Image(new FileInputStream("C:\\Users\\istea\\Pictures\\lapin.png")); //ne fonctionne pas sans le fileInput
    ImageView sprite = new ImageView(spriteSheet); //pour voir l'image
    sprite.setViewport(new Rectangle2D(0,0,455,500));
    sprite.setX(0); //coordonnees
    sprite.setY(0);
    sprite.setFitHeight(455); //pour changer la taille de l image
    sprite.setFitWidth(500);
    Group root = new Group(sprite);
    Pane pane = new Pane(root);
    Scene theScene = new GameScene(pane, 1000, 100,A);//taille de la fenêtre+affichage
    primaryStage.setScene(theScene);


    primaryStage.show();
}


         public static void main(String[] args) {
         launch(args);
         }
 }
