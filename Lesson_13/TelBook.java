import java.util.ArrayList;

public class TelBook {
    ArrayList<String[]> listNumTel = new ArrayList<String[]>();

    TelBook() {
    };

    public void add(String secName, String numTel) {
        String[] elArray = new String[] { secName, numTel };
        listNumTel.add(elArray);
    }

    public void get(String secName) {
        for (String[] el : listNumTel) {
            if (el[0] == secName) {
                System.out.println(secName + " " + el[1]);
            }
        }
    }

    public void show() {
        for (String[] el : listNumTel) {
            System.out.println(String.join(" ", el));
        }
    }
}