package Dog_and_cat;

public class Lesson_11_1_run {
    public static void main(String[] args) {
        Cat catSemen = new Cat("Семен");
        catSemen.run(200);
        catSemen.swim(1);
        catSemen.countAnimals();

        Dog dogJack = new Dog("Джек");
        dogJack.run(-5);
        Dog dogTimon = new Dog("Тимон");
        dogTimon.swim(0);
        Animal parrotLuna = new Animal("Luna", "parrot");

        Bowl bowl_1 = new Bowl();
        bowl_1.addFood(15);
        bowl_1.getFood();

        Cat[] arrCat = new Cat[3];
        arrCat[0] = catSemen;
        arrCat[1] = new Cat("Маруся");
        arrCat[2] = new Cat("Пушок");
        for (Cat cat : arrCat) {
            cat.feedTheCat(6, bowl_1);
        }
    }
}