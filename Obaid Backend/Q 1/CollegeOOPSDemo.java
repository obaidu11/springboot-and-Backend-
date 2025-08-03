// Interface
interface Department {
    void departmentInfo();
}

// Abstract class
abstract class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    abstract void role();  // abstract method
}

// Base class (superclass)
class Professor extends Person implements Department {
    String subject;

    // Constructor
    Professor(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Method Overloading
    void teach() {
        System.out.println(name + " teaches " + subject);
    }

    void teach(String topic) {
        System.out.println(name + " is teaching topic: " + topic);
    }

    // Overridden method from abstract class
    @Override
    void role() {
        System.out.println("Role: Teaching and Research");
    }

    // Implemented method from interface
    @Override
    public void departmentInfo() {
        System.out.println("Department: Computer Science");
    }
}

// Derived class (subclass)
class Student extends Person implements Department {
    int rollNumber;

    // Constructor
    Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    void showRollNumber() {
        System.out.println("Roll Number: " + rollNumber);
    }

    // Overridden method from abstract class
    @Override
    void role() {
        System.out.println("Role: Learning and Assignments");
    }

    // Implemented method from interface
    @Override
    public void departmentInfo() {
        System.out.println("Department: Information Technology");
    }
}

// Main class
public class CollegeOOPSDemo {
    public static void main(String[] args) {
        // Professor object
        Professor prof = new Professor("Dr. Shantosh", 45, "Data Structures");
        prof.displayBasicInfo();         // from abstract class
        prof.role();                     // overridden method
        prof.departmentInfo();           // from interface
        prof.teach();                    // overloaded method
        prof.teach("Trees & Graphs");    // overloaded method

        System.out.println("-------------");

        // Student object
        Student stu = new Student("MD Obaidullah", 23, 401);
        stu.displayBasicInfo();          // from abstract class
        stu.role();                      // overridden method
        stu.departmentInfo();            // from interface
        stu.showRollNumber();            // class-specific method
    }
}
