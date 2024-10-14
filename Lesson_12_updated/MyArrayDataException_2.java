import java.util.ArrayList;

public class MyArrayDataException_2 extends Exception {
    MyArrayDataException_2(ArrayList<String> arrErr) {
        super("Следующие элементы массива не преобразованы в Integer: " + arrErr.toString());
    }
}