public class Lesson_10 {
    public static void main(String arg[]){
        Employee ivan = new Employee("Ivanov Ivan Ivanovich", "specialist", "fth@jf", "+78954521895", 15000, 28);
        ivan.employeePrint();

        Employee[] arrEmp = new Employee[5];
        for(int i = 0; i < arrEmp.length; i++) {
            arrEmp[i] = new Employee(
                "Ivanov Ivan Ivanovich_" + i, "specialist_" + i, "fth@jf" + i, "+78954521895", 15000 + i, 28 + i
            );
            System.out.println(arrEmp[i].fio + " " + arrEmp[i].position + " " + arrEmp[i].email
            + " " + arrEmp[i].tel + " " + arrEmp[i].salary + " " + arrEmp[i].age);
        } 
        
        Park myPark = new Park();
        //for(Park park: myPark.listAttraction)
    }
}

class Employee {
    String fio;
    String position;
    String email;
    String tel;
    int salary;
    int age;
    Employee(String fio, String position, String email, String tel, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }
    void employeePrint(){
        System.out.println("Данные сотрудника: ФИО - " + fio + ", " + "должность - " + position + ", " + "email - " + email + ", " 
        + "телефон - " + tel + "," + "\n" + "з/п - " + salary + ", " + "возраст - " + age + ".");
    }
}

class Park {
    Attraction[] listAttraction = new Attraction[3];
    Park() {
        listAttraction[0] = new Attraction("Карусель", "10:00", "18:00", 350.00);
        listAttraction[1] = new Attraction("Комната страха", "10:00", "15:00", 150.00);
        listAttraction[2] = new Attraction("Колесо обозрения", "09:00", "21:00", 280.00);
    }
    class Attraction {
        String name;
        String openTime;
        String closeTime;
        double price;
        Attraction(String name, String openTime, String closeTime, double price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }
    }
}