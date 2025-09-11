package Leetcode;

public class CategorizeBoxAccordingtoCriteria2525 {
    public static void main(String[] args) {
        System.out.println(categorizeBox(100000,35,7000,300));
    }
    public static String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length *width*height;
        boolean flag=false;
        if(volume >= Math.pow(10, 9) || length >= Math.pow(10, 4) || width >= Math.pow(10, 4) || height >= Math.pow(10, 4)){
            flag=true;
        }
        if(mass >=100 && flag)
        {
            return "Both";
        }
        else if (mass >=100 )
        {
            return "Heavy";
        }
        else if (flag)
        {
            return "Bulky";
        }
        else return "Neither";
    }
}
