package Class;

public class StringClass {
    public static void main(String[] args) {
        String str1="Hello world";
        String str2="Hello";
        System.out.println("Original String = "+str1);
        System.out.println("Substring from 2nd index to 4th exclusive = "+str1.substring(2,4));
        System.out.println("Concat = "+str1+" "+str2);
        System.out.println("Length = "+str1.length());
        System.out.println("Str1 equals to Str2 = "+str1.equals(str2));
        System.out.println("Contains substring = "+str1.contains(str2));
    }
}
