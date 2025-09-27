package OPP;
public class Main1{
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.bark();
        dog.eat();
//        System.out.println();
    }
}

class Animal{
    void eat()
    {
        System.out.println("eating ");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("Barking ");
    }
}
