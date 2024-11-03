package Figure_interfaces;

public interface Figure {
    default double perimetr(double a, double b) {
        double p = 2 * (a + b);
        return p;
    }

    double area();

    default void fill(String color) {
    };

    default void border(String color) {
    };
}
