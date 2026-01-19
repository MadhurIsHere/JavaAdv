package OPP.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape=new Shape();
        shape.area();
        Rectangle rect=new Rectangle();
        rect.area();
        Triangle tri=new Triangle();
        tri.area();

        Shape sh=new Triangle();
        sh.area();

    }
}
