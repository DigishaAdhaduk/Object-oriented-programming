abstract class Employee {
    String name;
    String id;

    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    abstract void work();
}

class Manager extends Employee {
    Manager(String name, String id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Managing team");
    }
}

class Developer extends Employee {
    Developer(String name, String id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Writing code");
    }
}
class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.monthlySalary = salary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }
}

class EmployeeApp {
    public static void main(String[] args) {
        Employee emp1 = new Manager("Ram", "M123");
        emp1.work(); // Output: Managing team

        Employee emp2 = new Developer("Kiran", "D456");
        emp2.work(); // Output: Writing code

        FullTimeEmployee emp3 = new FullTimeEmployee("Shyam", 50000);
        System.out.println("Full-time employee salary: " + emp3.calculateSalary());
    }
}

