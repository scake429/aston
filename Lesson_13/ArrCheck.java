import java.util.HashMap;
import java.util.HashSet;

public class ArrCheck {
    ArrCheck() {
    }

    public void checkUniq(String[] arr) {
        HashSet<String> arrUniq = new HashSet<String>();
        for (int i = 0; i < arr.length; i++) {
            if (arrUniq.add(arr[i]) == false) {
                System.out.println("Элемент " + arr[i] + " встречается больше одного раза.");
            } else {
                arrUniq.add(arr[i]);
            }
        }
        System.out.print("Список уникальных элементов: ");
        for (String el : arrUniq) {
            System.out.print(el + "," + " ");
        }
    }

    public void countEl(String[] arr) {
        HashMap<String, Integer> mapForCheckArr = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int j;
            j = 1;
            if (mapForCheckArr.get(arr[i]) == null) {
                mapForCheckArr.put(arr[i], j);
            } else {
                mapForCheckArr.put(arr[i], j + 1);
            }
        }
        for (HashMap.Entry<String, Integer> el : mapForCheckArr.entrySet()) {
            System.out.println("\n Элемент: " + el.getKey() + ";" + " встречается столько раз:" + el.getValue());
        }
    }
}