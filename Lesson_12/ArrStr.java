public class ArrStr {
    ArrStr() {
    };

    public void checkArrStrLength(String[][] twoDim) throws MyArraySizeException, MyArrayDataException {
        int el;
        int s;
        s = 0;
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < twoDim[i].length; j++) {
                if (twoDim.length != 4 || twoDim[i].length != 4) {
                    throw new MyArraySizeException(twoDim.length, twoDim[i].length);
                }
                try {
                    el = Integer.parseInt(twoDim[i][j]);
                    s = s + el;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                } finally {
                    System.out.println("Сумма элементов, преобразованных к типу int, равна " + s);
                }
            }
        }
    }
}