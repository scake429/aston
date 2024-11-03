package Figure_interfaces;

public class Lesson_11_2_run {
    public static void main(String[] ags) {
        Circle cir_1 = new Circle(3.0);
        System.out.println("Длина окружности (периметр) круга равна " + cir_1.perimetr_circumference() + ".");
        System.out.println("Площадь круга равна " + cir_1.area() + ".");
        cir_1.fill("Зеленый");
        cir_1.border("Синий");

        Rectangle rect_1 = new Rectangle(2.0, 3.0);
        System.out.println("Периметр прямоугольника равен " + rect_1.perimetr(2.0, 3.0) + ".");
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