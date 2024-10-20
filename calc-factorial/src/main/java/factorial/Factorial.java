package factorial;

public class Factorial {
    public Factorial() {
    };

    public static long calc(int n) throws Exception {
        long f;
        f = 1;
        if (n < 0) {
            throw new Exception("The factorial is defined only for natural numbers.");
        } else if (n == 0) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                f = f * i;
            }
            return f;
        }
    }
}
