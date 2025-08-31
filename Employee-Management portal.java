abstract class Employee {
    String name;
    String id;

    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    abstract void work();
    abstract double calculateSalary();
}

class Manager extends Employee {
    double monthlySalary;

    Manager(String name, String id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void work() {
        System.out.println(name + " (" + id + ") is managing the team.");
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class Developer extends Employee {
    double monthlySalary;

    Developer(String name, String id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void work() {
        System.out.println(name + " (" + id + ") is writing code.");
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, String id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void work() {
        System.out.println(name + " (" + id + ") is working full-time.");
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    double hourlyWage;
    int hoursWorked;

    PartTimeEmployee(String name, String id, double hourlyWage, int hoursWorked) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    void work() {
        System.out.println(name + " (" + id + ") is working part-time.");
    }

    @Override
    double calculateSalary() {
        return hourlyWage * hoursWorked;
    }
}

class EmployeeApp {
    public static void main(String[] args) {
        Employee emp1 = new Manager("Ram", "M123", 80000);
        emp1.work();
        System.out.println("Manager salary: " + emp1.calculateSalary());

        Employee emp2 = new Developer("Kiran", "D456", 60000);
        emp2.work();
        System.out.println("Developer salary: " + emp2.calculateSalary());

        Employee emp3 = new FullTimeEmployee("Shyam", "F789", 50000);
        emp3.work();
        System.out.println("Full-time employee salary: " + emp3.calculateSalary());

        Employee emp4 = new PartTimeEmployee("Anita", "P101", 500, 80);
        emp4.work();
        System.out.println("Part-time employee salary: " + emp4.calculateSalary());
    }
}
