package factorial;

public class Main {
    public static void main(String[] args) {
        // Factorial fact = new Factorial();
        try {
            System.out.println("Factorial " + "equal " + Factorial.calc(5) + ".");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
