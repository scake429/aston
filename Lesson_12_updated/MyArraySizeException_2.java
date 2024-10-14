public class MyArraySizeException_2 extends Exception {
    MyArraySizeException_2(int i, int j) {
        super("Array size is not equal to 4*4, but " + i + "*" + j);
    }
}