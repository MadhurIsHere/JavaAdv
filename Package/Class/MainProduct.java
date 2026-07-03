package Class;

class Product {
    int id;
    String name;
    double price;

    // Parameterized constructor
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}

public class MainProduct {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 50000);
        Product p2 = new Product(102, "Mouse", 800);

        p1.display();
        p2.display();
    }
}
