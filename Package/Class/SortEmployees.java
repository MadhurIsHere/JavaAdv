package Class;

import java.util.ArrayList;
import java.util.List;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display ()
    {
        System.out.println("Name: "+name+", Salary: "+salary);
    }
}
public class SortEmployees{
    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Mohan",20000));
        employees.add(new Employee("Sohan",15000));
        employees.add(new Employee("Ram",30000));

        System.out.println("Before Sorting");
        employees.forEach(Employee::display);

        employees.sort((e1,e2)->Double.compare(e1.salary,e2.salary));

        System.out.println("After sorting");
        employees.forEach(Employee::display);
    }
}