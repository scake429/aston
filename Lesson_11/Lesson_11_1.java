public class Lesson_11_1 {

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


class Animal {
    String name;
    String species;
    int sRunMax;
    int sSwimMax;
    static int count = 0;
    Animal(String name, String species) {
        this.name = name;
        this.species = species;
        count ++;
    }
    void countAnimals() {
        System.out.println("Создано животных - " + count + ".");
    }
    void run(int s) {
        if (sRunMax == 0) {
            System.out.println(this.name + "-" + this.species + " не умеет бегать.");
        } else if (s > 0 && s <= sRunMax) {
            System.out.println(this.name + "-" + this.species + " пробежал " + s + " метров.");
        } else {
            System.out.println(this.name + "-" + this.species + " не может столько пробежать.");
        }   
    }
    void swim(int s) {
        if (sSwimMax == 0) {
            System.out.println(this.name + "-" + this.species + " не умеет плавать.");       
        } else if (s > 0 && s <= sSwimMax) {
            System.out.println(this.name + "-" + this.species + " проплыл " + s + " метров.");
        } else {
            System.out.println(this.name + "-" + this.species + " не может столько проплыть.");
        }
    }
}

class Cat extends Animal {
    boolean satiety;
    static int count = 0;
    Cat(String name) {
        super(name, "cat");
        sRunMax = 200;
        sSwimMax = 0;
        satiety = false;
        count ++;
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

class Dog extends Animal {
    static int count = 0;
    Dog(String name) {
        super(name, "dog");
        sRunMax = 500;
        sSwimMax = 10;
        count ++;
    }
    void countDog() {
        System.out.println("Создано собак - " + count + ".");
    }
}

class Bowl {
    int food = 0;
    Bowl() {}
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
            System.out.println("Что-то пошло не так с удалением корма из тарелки - " + "в тарелке корма " + food + ", " +
            "хотите удалить " + n + " корма.");
            return false;
        }
    }
}