import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class GameScene extends Scene {
  private Camera camera;
  private StaticThing StaticThingLeft;
  private StaticThing StaticThingRight;
  private Hero hero;
  //private AnimationTimer timer;

    public GameScene(Pane pane,double width, double height, Camera camera) throws Exception {
        super(pane,width,height);
        this.camera = camera;
        //this.staticThingLeft=StaticThingLeft;//on initialise le background
        //this.staticThingRight=StaticThingRight;
        StaticThingLeft=new StaticThing(800,800,"C:\\Users\\istea\\Downloads\\desert.png");
        StaticThingRight=new StaticThing(800,800,"C:\\Users\\istea\\Downloads\\desert.png");
        this.hero=new Hero(100,600,0,1,1,4,80,150,85,"C:\\Users\\istea\\Downloads\\heros (1).png");
        System.out.println(hero.index);
        pane.getChildren().add(StaticThingLeft.getImageView());
        pane.getChildren().add(StaticThingRight.getImageView()); // pour ajouter les background au "pane", c'est lui qui contient ce qu'il faut afficher
        pane.getChildren().add(hero.getSheet());
        //StaticThingRight.getImageView().setLayoutX(StaticThingLeft.getImageView().getImage().getWidth());// pour mettre les deux images côte à côte
        //StaticThingRight.getImageView().setLayoutY(0); //aligne horizontalement
        render (StaticThingLeft,StaticThingRight);// pour modifier le background selon la position de la camera dans grace a render


    }
    public void render (StaticThing staticThingLeft, StaticThing staticThingRight) {
        double a;
        double c;
        staticThingLeft.getImageView().setLayoutX(-camera.getX()); //positionnement du coin en haut à gauche de la première image
        staticThingLeft.getImageView().setLayoutY(-camera.getY());

        staticThingRight.getImageView().setLayoutX(staticThingLeft.getImageView().getLayoutX() + staticThingLeft.getImageView().getImage().getWidth()); //l'image de droite est à la positions
        staticThingRight.getImageView().setLayoutY(-camera.getY());

        a = camera.getX() / (int) staticThingLeft.getImageView().getImage().getWidth(); //on recupere le nombre de boucles par division entiere
        System.out.println(a);
        c = camera.getX() - a * staticThingLeft.getImageView().getImage().getWidth();//repositionnement vers la droite
        if (a != 0) {
            if (camera.getX() >= a % 2 * staticThingLeft.getImageView().getImage().getWidth() * a + c) { //repositionnement une fois sur 2
                staticThingLeft.getImageView().setLayoutX(-c);
                staticThingRight.getImageView().setLayoutX(staticThingLeft.getImageView().getImage().getWidth() - c);
            }

            if (a % 2 * camera.getX() >= staticThingLeft.getImageView().getImage().getWidth() * a + c) {
                staticThingRight.getImageView().setLayoutX(-c);
                staticThingLeft.getImageView().setLayoutX(staticThingLeft.getImageView().getImage().getWidth() - c);
            }

        }
        System.out.println(StaticThingLeft.getImageView().getLayoutX());
        AnimationTimer timer = new AnimationTimer() {

        public void handle ( long time){
            hero.update(time);
            //System.out.println(hero.index);
            camera.update(time,hero.getX());
            GameScene.update(time);

        }


    }; //pourquoi un point virgule ?
        timer.start();
    }

    private static void update(long time) {
      //render(StaticThingLeft,StaticThingRight);// pour modifier le background selon la position de la camera dans grace a render

    }


    //  public void setImageView(fileName) {    }
   // StaticThing StaticThingLeft=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");
    //StaticThing StaticThingRight=new StaticThing(500,500,"C:\\Users\\istea\\Downloads\\desert.png");

}



