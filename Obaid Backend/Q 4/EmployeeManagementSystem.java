import java.util.*;

// Employee class with attributes and methods
class Employee {
    private String empId;
    private String name;
    private String department;
    private double salary;

    public Employee(String empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Dept: " + department + ", Salary: Rs." + salary;
    }
}

// Main management class
public class EmployeeManagementSystem {
    private static final HashMap<String, Employee> employeeMap = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> updateEmployee();
                    case 3 -> deleteEmployee();
                    case 4 -> displayEmployees();
                    case 5 -> searchEmployee();
                    case 6 -> {
                        System.out.println("Exiting... Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please enter 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        if (employeeMap.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        try {
            double salary = Double.parseDouble(sc.nextLine());
            employeeMap.put(id, new Employee(id, name, dept, salary));
            System.out.println("Employee added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary input!");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = sc.nextLine();
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter new Name (or press Enter to skip): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) emp.setName(name);

        System.out.print("Enter new Department (or press Enter to skip): ");
        String dept = sc.nextLine();
        if (!dept.isEmpty()) emp.setDepartment(dept);

        System.out.print("Enter new Salary (or press Enter to skip): ");
        String salaryStr = sc.nextLine();
        if (!salaryStr.isEmpty()) {
            try {
                double salary = Double.parseDouble(salaryStr);
                emp.setSalary(salary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary input! Skipped updating salary.");
            }
        }

        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();
        if (employeeMap.remove(id) != null) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void displayEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\n--- Employee List ---");
            for (Employee emp : employeeMap.values()) {
                System.out.println(emp);
            }
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        String id = sc.nextLine();
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            System.out.println("Employee Found: " + emp);
        } else {
            System.out.println("Employee not found!");
        }
    }
}
