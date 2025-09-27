package OPP;

public class Car {
    String color;
    int speed;
    String model;
    Car(String color,int speed,String model)
    {
        this.color=color;
        this.speed=speed;
        this.model=model;
    }
    void display() {
        System.out.println("The color is:"+this.color);
        System.out.println("The speed is:"+this.speed);
        System.out.println("The model is:"+this.model);
    }

    public static void main(String[] args) {
        Car car1=new Car("Red",320,"F1");
        car1.display();
    }

}

