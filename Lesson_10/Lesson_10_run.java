public class Lesson_10_run {
    public static void main(String[] arg) {
        Employee ivan = new Employee("Ivanov Ivan Ivanovich", "specialist", "fth@jf", "+78954521895", 15000, 28);
        ivan.employeePrint();

        Employee[] arrEmp = new Employee[5];
        for (int i = 0; i < arrEmp.length; i++) {
            arrEmp[i] = new Employee(
                    "Ivanov Ivan Ivanovich_" + i, "specialist_" + i, "fth@jf" + i, "+78954521895", 15000 + i, 28 + i);
            arrEmp[i].employeePrint();
        }

        Park myPark = new Park();
        myPark.addAttr("Карусель", "10:00", "18:00", 350.00);
        myPark.addAttr("Комната страха", "10:00", "15:00", 150.00);
        myPark.addAttr("Колесо обозрения", "09:00", "21:00", 280.00);
        myPark.show();
    }
}
