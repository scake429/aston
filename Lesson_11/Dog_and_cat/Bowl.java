package Dog_and_cat;

public class Bowl {
    int food = 0;

    Bowl() {
    }

    void addFood(int n) {
        if (n >= 0) {
            food = food + n;
        } else {
            System.out.println("Нельзя положить в тарелку отрицательное число корма.");
        }
    }

    void getFood() {
        System.out.println("Сейчас в тарелке " + food + " корма.");
    }

    boolean remove(int n) {
        if (n >= 0 && food > 0 && food >= n) {
            food = food - n;
            return true;
        } else {
            System.out
                    .println("Что-то пошло не так с удалением корма из тарелки - " + "в тарелке корма " + food + ", " +
                            "хотите удалить " + n + " корма.");
            return false;
        }
    }
}
