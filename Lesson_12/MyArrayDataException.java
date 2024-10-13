public class MyArrayDataException extends Exception {
    MyArrayDataException(int i, int j) {
        super("Array element [" + i + "]" + "[" + j + "]" + " cannot be converted to Integer.");
    }
}