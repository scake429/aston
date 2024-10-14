public class Data_2 {
    Data_2() {
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