public class Lesson_13_run {
    public static void main(String[] args) {
        String[] arr = new String[] { "Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун",
                "Марс", "Уран", "Венера" };
        ArrCheck arrCheck = new ArrCheck();
        arrCheck.checkUniq(arr);
        arrCheck.countEl(arr);

        TelBook telBook = new TelBook();
        telBook.add("Иванов", "89653218745");
        telBook.add("Петрова", "89758542135");
        telBook.add("Иванов", "546987");
        telBook.show();
        telBook.get("Петрова");
        telBook.get("Иванов");
    }
}