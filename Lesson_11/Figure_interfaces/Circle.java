package Figure_interfaces;

public class Circle implements Figure {
    double r;
    String fillColor;
    String borderColor;

    Circle(double r) {
        this.r = r;
    }

    double perimetr_circumference() {
        return (2 * 3.14 * this.r);
    }

    @Override
    public double area() {
        return (3.14 * Math.pow(this.r, 2));
    }

    public void fill(String color) {
        this.fillColor = color;
        System.out.println("У круга с радиусом " + this.r + " цвет заливки - " + this.fillColor);
    }

    public void border(String color) {
        this.borderColor = color;
        System.out.println("У круга с радиусом " + this.r + " цвет границы - " + this.borderColor);
    }
}
