import java.io.FileInputStream;

public class Hero extends AnimatedThing {
    private double Cnt=0;
    private double arr=10; //donc tous les 10 eme de seconde car une frame=1ms
    public Hero(double x, double y, int action, int index, int duration, int max, int windowSizex,int windowSizey, int offset, String fileName) throws Exception {
        super(x, y, action, index, duration, max, windowSizex,windowSizey, offset, fileName);
    }

    public void update(long time) {
        Cnt += 1; //fonctionne le Counter en microprocesseur
        if (Cnt==arr) {
            Cnt=0; //res
            int newIndex=this.index+1;
            if (newIndex==5) {
            newIndex=0;
        }
            this.setIndex(newIndex);
            updateViewport();
        }

        //System.out.println(newIndex);
    }

}






