class Animal {
    String name;
    String sound;

    // Parameterized constructor
    Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    void display() {
        System.out.println("Animal Name: " + name);
        System.out.println("Sound: " + sound);
    }
}

class Dog extends Animal {
    String breed;

    // Parameterized constructor using super()
    Dog(String name, String sound, String breed) {
        super(name, sound);
        this.breed = breed;
    }

    void display() {
        super.display();
        System.out.println("Breed: " + breed);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Tommy", "Bark", "German Shepherd");
        d.display();
    }
}
