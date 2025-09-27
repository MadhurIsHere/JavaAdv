package Class;

public class Car {
    String model;
    int speed;
    Car(int speed, String model)
    {
        this.model=model;
        this.speed=speed;
    }
    void display()
    {
        System.out.println("Speed of the car is: "+speed);
        System.out.println("Model is: "+model);
    }
    public static void main(String[] args) {
        Car c=new Car(320,"XUV900");
        c.display();
    }
}
