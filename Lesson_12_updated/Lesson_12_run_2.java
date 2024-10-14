public class Lesson_12_run_2 {
    public static void main(String[] args) {
        Data_2 data = new Data_2();
        String[][] dataArr44 = data.createTwoDimArr(4, 4);
        String[][] dataArr32 = data.createTwoDimArr(3, 4);
        data.show(dataArr44);

        ArrStr_2 arrStr = new ArrStr_2();
        try {
            arrStr.checkArrStrLength(dataArr44);
        } catch (MyArraySizeException_2 e) {
            System.err.println(e);
        } catch (MyArrayDataException_2 e) {
            System.out.println(e);
        }
    }
}