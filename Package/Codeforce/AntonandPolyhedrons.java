package Codeforce;

import java.util.HashMap;
import java.util.Scanner;

public class AntonandPolyhedrons {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tetrahedron", 4);
        map.put("Cube", 6);
        map.put("Octahedron", 8);
        map.put("Dodecahedron", 12);
        map.put("Icosahedron", 20);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            ans += map.get(name);
        }
        System.out.println(ans);
    }
}
