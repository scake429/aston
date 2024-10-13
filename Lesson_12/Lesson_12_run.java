public class Lesson_12_run {
    public static void main(String[] args) {
        Data data = new Data();
        String[][] dataArr44 = data.createTwoDimArr(4, 4);
        String[][] dataArr32 = data.createTwoDimArr(3, 4);
        data.show(dataArr44);

        ArrStr arrStr = new ArrStr();
        try {
            arrStr.checkArrStrLength(dataArr44);
        } catch (MyArraySizeException e) {
            System.err.println(e);
            // e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }
}

class Data {
    Data() {
    };

    public String[][] createTwoDimArr(int i, int j) {
        String[][] twoDimArr = new String[i][j];
        for (i = 0; i < twoDimArr.length; i++) {
            for (j = 0; j < twoDimArr[i].length; j++) {
                if (Math.random() > 0.3) {
                    twoDimArr[i][j] = Integer.toString((int) (Math.random() * 5));
                } else {
                    twoDimArr[i][j] = "dso";
                }
            }
        }
        return twoDimArr;
    }

    public void show(String[][] twoDimArr) {
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                System.out.print("\t" + twoDimArr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}