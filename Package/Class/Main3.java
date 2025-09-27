package Class;

class Animal1 {  // uses Animal1 as Animal was used before in the same package
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal1 {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
public class Main3 {
    public static void main(StringClass[] args) {
        Animal1 myAnimal = new Animal1();
        myAnimal.sound();

        Dog myDog = new Dog();
        myDog.sound();
    }
}
