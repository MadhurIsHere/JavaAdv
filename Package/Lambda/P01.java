package Lambda;

import java.util.ArrayList;

public class P01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        list.forEach((element) -> System.out.println(element * 10));
    }
}
