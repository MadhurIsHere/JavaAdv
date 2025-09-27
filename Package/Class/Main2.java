package Class;

class Vehicle {
    void fuelType() {
        System.out.println("Vehicle uses fuel");
    }
}
class Car1 extends Vehicle { // uses car1 inplace of car as I had created another class in same package that why showing me error for duplicating the class

    void numberOfWheels() {
        System.out.println("Car has 4 wheels");
    }
}
public class Main2 {
    public static void main(StringClass[] args) {
        Car1 myCar = new Car1();
        myCar.fuelType();
        myCar.numberOfWheels();
    }
}