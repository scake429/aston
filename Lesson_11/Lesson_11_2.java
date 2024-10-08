public class Lesson_11_2 {
    public static void main(String[] ags) {
        Circle cir_1 = new Circle(3.0);
        System.out.println("Длина окружности (периметр) круга равна " + cir_1.perimetr_circumference() + ".");
        System.out.println("Площадь круга равна " + cir_1.area() + ".");
        cir_1.fill("Зеленый");
        cir_1.border("Синий");

        Rectangle rect_1 = new Rectangle(2.0, 3.0);
        System.out.println("Периметр прямоугольника равен " + (rect_1.p = rect_1.perimetr(2.0, 3.0)) + ".");
        System.out.println("Площадь прямоугольника равна " + rect_1.area() + ".");
        rect_1.fill("Желтый");
        rect_1.border("Оранжевый");

        Triangle triag_1 = new Triangle(2.0, 3.0, 4.0);
        System.out.println("Периметр треугольника равен " + triag_1.perimetrTrian() + ".");
        System.out.println("Площадь треугольника равна " + triag_1.area() + ".");
        rect_1.fill("Розовый");
        rect_1.border("Синий");
    }
}


interface Figure {
    default double perimetr(double a, double b) {
        double p = 2 * (a + b);
        return p;
    }
    double area();
    default void fill(String color) {};
    default void border(String color) {};
}

class Circle implements Figure {
    double r;
    double p;
    double s;
    String fillColor;
    String borderColor;
    Circle(double r) {
        this.r = r;
    }
    double perimetr_circumference() {
        return this.p = 2 * 3.14 * this.r;
    }
    @Override
    public double area() {
        return this.s = 3.14 * Math.pow(this.r, 2);
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

class Rectangle implements Figure {
    double a;
    double b;
    double p;
    double s;
    String fillColor;
    String borderColor;
    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double area() {
        return this.s = a * b;
    };
    public void fill(String color) {
        this.fillColor = color;
        System.out.println("У прямоугольника со сторонами " + this.a + ", " + this.b + " цвет заливки - " + this.fillColor);
    }
    public void border(String color) {
        this.borderColor = color;
        System.out.println("У прямоугольника со сторонами " + this.a + ", " + this.b + " цвет границы - " + this.borderColor);
    }
}

class Triangle implements Figure {
    double a;
    double b;
    double c;
    double p;
    double s;
    String fillColor;
    String borderColor;
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double perimetrTrian(){
        return this.p = this.a + this.b + this.c;
    }
    @Override
    public double area() {
        double pHalf = this.p / 2;
        return this.s = Math.sqrt(pHalf * (pHalf - this.a) * (pHalf - this.b) * (pHalf - this.c));
    };
    public void fill(String color) {
        this.fillColor = color;
        System.out.println("У треугольника со сторонами " + this.a + ", " + this.b + ", " + this.c + " цвет заливки - " + this.fillColor);
    }
    public void border(String color) {
        this.borderColor = color;
        System.out.println("У треугольника со сторонами " + this.a + ", " + this.b + ", " + this.c + " цвет границы - " + this.borderColor);
    }
}