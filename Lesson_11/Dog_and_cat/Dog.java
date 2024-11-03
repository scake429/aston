package Dog_and_cat;

public class Dog extends Animal {
    static int count = 0;

    Dog(String name) {
        super(name, "dog");
        sRunMax = 500;
        sSwimMax = 10;
        count++;
    }

    void countDog() {
        System.out.println("Создано собак - " + count + ".");
    }
}
