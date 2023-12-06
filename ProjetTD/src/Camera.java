import static java.lang.System.currentTimeMillis;

public class Camera {
    private static int x;
    private int y;

    public int fm=1;
    public double km=1.2;
    public double vx=1;
    double time2=0;
    double time1=0;

    public Camera(int x, int y) {
        this.x = x;
        this.y=y;



    }

    public static int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void setX(int x) {
        Camera.x = x;
    }

    @Override
    public String toString(){
        return x+","+y;
    }

    public void update(long time, double herox) {
        time1=currentTimeMillis();
        double dtime=time2-time1;
        double ax=km*(herox-Camera.getX())-fm*vx; //equations de masse
        double deltavx=vx+ax*dtime;
        double deltax=vx*dtime;
        Camera.setX(Camera.getX()+100);
        time2=currentTimeMillis();
    }
}
