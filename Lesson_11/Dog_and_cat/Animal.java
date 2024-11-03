package Dog_and_cat;

public class Animal {
    String name;
    String species;
    int sRunMax;
    int sSwimMax;
    static int count = 0;

    Animal(String name, String species) {
        this.name = name;
        this.species = species;
        count++;
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
