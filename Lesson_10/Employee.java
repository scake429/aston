public class Employee {
    private String fio;
    private String position;
    private String email;
    private String tel;
    private int salary;
    private int age;

    Employee(String fio, String position, String email, String tel, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public void employeePrint() {
        System.out.println(
                "Данные сотрудника: ФИО - " + fio + ", " + "должность - " + position + ", " + "email - " + email + ", "
                        + "телефон - " + tel + "," + "\n" + "з/п - " + salary + ", " + "возраст - " + age + ".");
    }
}
