package Figure_interfaces;

public class Triangle implements Figure {
    double a;
    double b;
    double c;
    String fillColor;
    String borderColor;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimetrTrian() {
        return this.a + this.b + this.c;
    }

    @Override
    public double area() {
        double pHalf = (this.a + this.b + this.c) / 2;
        return Math.sqrt(pHalf * (pHalf - this.a) * (pHalf - this.b) * (pHalf - this.c));
    };

    public void fill(String color) {
        this.fillColor = color;
        System.out.println("У треугольника со сторонами " + this.a + ", " + this.b + ", " + this.c + " цвет заливки - "
                + this.fillColor);
    }

    public void border(String color) {
        this.borderColor = color;
        System.out.println("У треугольника со сторонами " + this.a + ", " + this.b + ", " + this.c + " цвет границы - "
                + this.borderColor);
    }
}
