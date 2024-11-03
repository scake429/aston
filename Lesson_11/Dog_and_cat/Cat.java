package Dog_and_cat;

public class Cat extends Animal {
    boolean satiety;
    static int count = 0;

    Cat(String name) {
        super(name, "cat");
        sRunMax = 200;
        sSwimMax = 0;
        satiety = false;
        count++;
    }

    void countCat() {
        System.out.println("Создано котов - " + count + ".");
    }

    void feedTheCat(int n, Bowl bowl) {
        if (bowl.remove(n)) {
            System.out.println("Кот " + this.name + " скушал " + n + " корма " + "и сыт.");
            satiety = true;
        } else {
            System.out.println("Коту " + this.name + " не хватило корма в миске, он голоден.");
            satiety = false;
        }
    }
}
