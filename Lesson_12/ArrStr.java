public class ArrStr {
    ArrStr() {};
    public void checkArrStrLength(String[][] twoDim) throws MyArraySizeException {
        int el;
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < twoDim[i].length; j++) {
                if (twoDim.length != 4 || twoDim[i].length != 4) {
                    throw new MyArraySizeException(twoDim.length, twoDim[i].length);
                }
                if (Integer.valueOf(twoDim[i][j]) instanceof Integer) {
                    
                }
                 
            }
        }
    }
}