import java.util.ArrayList;

public class Park {
    private ArrayList<Attraction> listAttraction;

    Park() {
        this.listAttraction = new ArrayList<Attraction>();
    }

    public void addAttr(String name, String openTime, String closeTime, double price) {
        listAttraction.add(new Attraction(name, openTime, closeTime, price));
    }

    public void show() {
        for (Attraction parkAttr : this.listAttraction) {
            System.out.println(parkAttr.name + " " + parkAttr.openTime + " " + parkAttr.closeTime + " " + parkAttr.price);
        }
    }

    class Attraction {
        private String name;
        private String openTime;
        private String closeTime;
        private double price;

        Attraction(String name, String openTime, String closeTime, double price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }
    }
}