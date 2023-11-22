public class Camera {
    private int x;
    private int y;
    public Camera(int x, int y) {


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return x+","+y;
    }
}
