public class Lesson_5{
    public static void main(String arg[]){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumTwoNumbers(15, 78));
        checkNumber(-9);
        System.out.println(checkNumberBool(0));
        printStr("Проверяем метод - печатаем в консоль строку", 3);
        System.out.println(checkLeapYear(2300));
        changeArr();
        fillArr();
        changeArrLessSix();
        arrTwoDimens();
    }

    static void printThreeWords(){
        System.out.print("Orange\n");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    static void checkSumSign(){
        int a = 10;
        int b = -19;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    static void printColor(){
        int value = 178;
        if (value <= 0) {
            System.out.println("Красный");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    static void compareNumbers(){
        int a = 5;
        int b = 528;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    static boolean sumTwoNumbers(int num1, int num2) {
        int sum = num1 + num2;
        return (sum >= 10) && (sum <= 20);
    }
    static void checkNumber(int num) {
        System.out.println(num >= 0 ? "Положительное число" : "Отрицательное число");
        /*System.out.print(check);*/
    }
    static boolean checkNumberBool(int num) {
        return num < 0;       
    }
    static void printStr(String str, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(str);
        }
    }
    static boolean checkLeapYear(int year) {
        if ((year % 100 == 0) && (year % 400 != 0)){
            return false;
        } else if ((year % 4 == 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    static void changeArr() {
        int[] nums = new int[] {1, 1, 0, 0, 1, 0, 1};
        for (int i : nums) {
            System.out.print("Было " + nums[i] + " ");
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
            System.out.println("Стало " + nums[i]);
        }
    }
    static void fillArr(){
        int nums[] = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
            /*System.out.println(nums[i]);*/
        }
    }
    static void changeArrLessSix() {
        int nums[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        /*for (int i : nums) {
            if (nums[i] < 6 ) {
                nums[i] = nums[i] * 2;
                System.out.println(i + "-й элемент нового массива равен " + nums[i]);
            }
        }*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6 ) {
                nums[i] = nums[i] * 2;
            }
            System.out.println(i + "-й элемент нового массива равен " + nums[i]);
        }
    }
    static void arrTwoDimens() {
        int [][] nums = new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i == j) {
                    nums[i][j] = 1;
                }
                /*System.out.println(nums[i][j]);*/
            }
            
        }
    }
}


