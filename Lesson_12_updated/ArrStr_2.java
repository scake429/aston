import java.util.ArrayList;

public class ArrStr_2 {
    ArrStr_2() {
    };

    public void checkArrStrLength(String[][] twoDim) throws MyArraySizeException_2, MyArrayDataException_2 {
        int el;
        int s;
        s = 0;
        ArrayList<String> arrErr = new ArrayList<String>();
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < twoDim[i].length; j++) {
                if (twoDim.length != 4 || twoDim[i].length != 4) {
                    throw new MyArraySizeException_2(twoDim.length, twoDim[i].length);
                }
                try {
                    el = Integer.parseInt(twoDim[i][j]);
                    s = s + el;
                } catch (NumberFormatException e) {
                    arrErr.add("[" + i + ";" + j + "]=" + twoDim[i][j]);
                }
            }
        }
        System.out.println(s);
        if (arrErr.size() > 0) {
            throw new MyArrayDataException_2(arrErr);
        }
    }
}