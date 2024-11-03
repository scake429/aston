package Figure_interfaces;

public class Rectangle implements Figure {
    double a;
    double b;
    String fillColor;
    String borderColor;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    };

    public void fill(String color) {
        this.fillColor = color;
        System.out.println(
                "У прямоугольника со сторонами " + this.a + ", " + this.b + " цвет заливки - " + this.fillColor);
    }

    public void border(String color) {
        this.borderColor = color;
        System.out.println(
                "У прямоугольника со сторонами " + this.a + ", " + this.b + " цвет границы - " + this.borderColor);
    }
}
