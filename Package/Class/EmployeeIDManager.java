package Class;

import java.util.TreeSet;

public class EmployeeIDManager {
    public static void main(String[] args) {
        // Create a TreeSet to store employee IDs
        TreeSet<Integer> employeeIDs = new TreeSet<>();

        // Add employee IDs (including duplicates)
        employeeIDs.add(102);
        employeeIDs.add(101);
        employeeIDs.add(105);
        employeeIDs.add(103);
        employeeIDs.add(101); // Duplicate
        employeeIDs.add(104);

        // Display the TreeSet contents
        System.out.println("Employee IDs in ascending order:");
        for (int id : employeeIDs) {
            System.out.println(id);
        }
    }
}
