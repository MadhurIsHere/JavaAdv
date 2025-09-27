package Class;

abstract class Animal {
    abstract void sound();
}
class Cat extends Animal{
    void sound(){
        System.out.println("Cat Meows");
    }
}

public class Main {
    public static void main(StringClass[] args) {
        Animal animal=new Cat();
        animal.sound();
    }
}
