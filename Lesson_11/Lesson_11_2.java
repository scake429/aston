public class Lesson_11_2 {
    public static void main(String[] ags) {
        Circle cir_1 = new Circle(2.0);
        
    }
}

interface Figure {
    default double perimetr() {
        int countEdge;
        double[] arrEdge = new double[countEdge];
        double p = 0;
        for (double edge : arrEdge) {
            p = p + edge;
        }
        return p;
    }
    int area(double[] arrEdge);
    default void fill(String color) {
        String colorFill;
        this.colorFill = color;
    }
    default void border(String color) {
        String colorBorder;
        this.colorBorder = color;
    }
}

class Circle implements Figure {
    Circle(double r) {
        countEdge = 1;
        arrEdge[0] = r;
    }
    @Override
    double perimetr(double[] arrEdge) {
        double p;
        for (double edge : arrEdge) {
            p = 2 * 3.14 * edge;
        }
        return p; 
    }
}