public class MyArraySizeException extends Exception {
    MyArraySizeException(int i, int j) {
        super("Array size is not equal to 4*4, but " + i + "*" + j);
    }
}