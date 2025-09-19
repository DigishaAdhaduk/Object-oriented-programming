import java.io.* ;
import java.util.* ;


// Interface for calculating salary
interface Payable {

    double calculateSalary( ) ;
}


// Base Employee class
abstract class Employee implements Payable {

    protected String name ;
    protected String id ;

    Employee( String name , String id ) {

        this.name = name ;
        this.id   = id ;
    }

    abstract void work( ) ;

    @Override
    public String toString( ) {

        return "ID: " + id + " | Name: " + name + " | Role: " + this.getClass( ).getSimpleName( ) ;
    }
}


// Manager class
class Manager extends Employee {

    private double monthlySalary ;
    private double bonus ;

    Manager( String name , String id , double monthlySalary , double bonus ) {

        super( name , id ) ;
        this.monthlySalary = monthlySalary ;
        this.bonus = bonus ;
    }

    @Override
    void work( ) {

        System.out.println( name + " (" + id + ") is managing the team." ) ;
    }

    @Override
    public double calculateSalary( ) {

        return monthlySalary + bonus ;
    }

    public void setSalary( double salary ) {

        this.monthlySalary = salary ;
    }
}


// Developer class
class Developer extends Employee {

    private double monthlySalary ;

    Developer( String name , String id , double monthlySalary ) {

        super( name , id ) ;
        this.monthlySalary = monthlySalary ;
    }

    @Override
    void work( ) {

        System.out.println( name + " (" + id + ") is writing code." ) ;
    }

    @Override
    public double calculateSalary( ) {

        return monthlySalary ;
    }

    public void setSalary( double salary ) {

        this.monthlySalary = salary ;
    }
}


// Full-time employee
class FullTimeEmployee extends Employee {

    private double monthlySalary ;

    FullTimeEmployee( String name , String id , double monthlySalary ) {

        super( name , id ) ;
        this.monthlySalary = monthlySalary ;
    }

    @Override
    void work( ) {

        System.out.println( name + " (" + id + ") is working full-time." ) ;
    }

    @Override
    public double calculateSalary( ) {

        return monthlySalary ;
    }

    public void setSalary( double salary ) {

        this.monthlySalary = salary ;
    }
}


// Part-time employee
class PartTimeEmployee extends Employee {

    private double hourlyWage ;
    private int hoursWorked ;
    private int overtimeHours ;

    PartTimeEmployee( String name , String id , double hourlyWage , int hoursWorked , int overtimeHours ) {

        super( name , id ) ;
        this.hourlyWage = hourlyWage ;
        this.hoursWorked = hoursWorked ;
        this.overtimeHours = overtimeHours ;
    }

    @Override
    void work( ) {

        System.out.println( name + " (" + id + ") is working part-time." ) ;
    }

    @Override
    public double calculateSalary( ) {

        double normalPay   = hourlyWage * hoursWorked ;
        double overtimePay = overtimeHours * hourlyWage * 1.5 ;

        return normalPay + overtimePay ;
    }

    public void setSalary( double wage ) {

        this.hourlyWage = wage ;
    }
}



// Main HR System
class EmployeeApp {

    private static final Scanner sc = new Scanner( System.in ) ;

    private static final List<Employee> employees = new ArrayList<>( ) ;


    // Add employee
    private static void addEmployee( ) {

        System.out.println( "\nSelect Employee Type:" ) ;
        System.out.println( "1. Manager" ) ;
        System.out.println( "2. Developer" ) ;
        System.out.println( "3. Full-time Employee" ) ;
        System.out.println( "4. Part-time Employee" ) ;
        System.out.print( "Enter choice: " ) ;

        int choice = sc.nextInt( ) ;
        sc.nextLine( ) ;


        System.out.print( "Enter Name: " ) ;
        String name = sc.nextLine( ) ;

        System.out.print( "Enter ID: " ) ;
        String id = sc.nextLine( ) ;


        switch( choice ) {

            case 1 -> {

                System.out.print( "Enter Monthly Salary: " ) ;
                double mSalary = sc.nextDouble( ) ;

                System.out.print( "Enter Bonus: " ) ;
                double bonus = sc.nextDouble( ) ;

                employees.add( new Manager( name , id , mSalary , bonus ) ) ;
            }

            case 2 -> {

                System.out.print( "Enter Monthly Salary: " ) ;
                double dSalary = sc.nextDouble( ) ;

                employees.add( new Developer( name , id , dSalary ) ) ;
            }

            case 3 -> {

                System.out.print( "Enter Monthly Salary: " ) ;
                double fSalary = sc.nextDouble( ) ;

                employees.add( new FullTimeEmployee( name , id , fSalary ) ) ;
            }

            case 4 -> {

                System.out.print( "Enter Hourly Wage: " ) ;
                double wage = sc.nextDouble( ) ;

                System.out.print( "Enter Hours Worked: " ) ;
                int hours = sc.nextInt( ) ;

                System.out.print( "Enter Overtime Hours: " ) ;
                int overtime = sc.nextInt( ) ;

                employees.add( new PartTimeEmployee( name , id , wage , hours , overtime ) ) ;
            }

            default -> System.out.println( "Invalid choice!" ) ;
        }
    }


    // View all employees
    private static void viewEmployees( ) {

        if( employees.isEmpty( ) ) {

            System.out.println( "\nNo employees found." ) ;
            return ;
        }

        System.out.println( "\n--- Employee List ---" ) ;


        // Writing for-loop in detailed human way
        for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

            System.out.println( employees.get( i ) ) ;
        }
    }


    // Search employee by ID
    private static void searchEmployee( ) {

        System.out.print( "\nEnter Employee ID to search: " ) ;
        String searchId = sc.next( ) ;

        for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

            Employee emp = employees.get( i ) ;

            if( emp.id.equalsIgnoreCase( searchId ) ) {

                System.out.println( "Employee Found → " + emp ) ;
                emp.work( ) ;
                return ;
            }
        }

        System.out.println( "Employee not found!" ) ;
    }


    // Update employee salary
    private static void updateSalary( ) {

        System.out.print( "\nEnter Employee ID to update salary: " ) ;
        String searchId = sc.next( ) ;

        for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

            Employee emp = employees.get( i ) ;

            if( emp.id.equalsIgnoreCase( searchId ) ) {

                System.out.print( "Enter New Salary / Hourly Wage: " ) ;
                double newSalary = sc.nextDouble( ) ;

                if( emp instanceof Manager m ) {
                    m.setSalary( newSalary ) ;
                }
                else if( emp instanceof Developer d ) {
                    d.setSalary( newSalary ) ;
                }
                else if( emp instanceof FullTimeEmployee f ) {
                    f.setSalary( newSalary ) ;
                }
                else if( emp instanceof PartTimeEmployee p ) {
                    p.setSalary( newSalary ) ;
                }

                System.out.println( "Salary updated successfully!" ) ;
                return ;
            }
        }

        System.out.println( "Employee not found!" ) ;
    }


    // Delete employee
    private static void deleteEmployee( ) {

        System.out.print( "\nEnter Employee ID to delete: " ) ;
        String searchId = sc.next( ) ;

        for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

            Employee emp = employees.get( i ) ;

            if( emp.id.equalsIgnoreCase( searchId ) ) {

                employees.remove( i ) ;
                System.out.println( "Employee deleted successfully!" ) ;
                return ;
            }
        }

        System.out.println( "Employee not found!" ) ;
    }


    // Export employee data to file
    private static void exportToFile( ) {

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( "employees.txt" ) ) ) {

            for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

                Employee emp = employees.get( i ) ;

                writer.write( emp + " | Salary: ₹" + emp.calculateSalary( ) ) ;
                writer.newLine( ) ;
            }

            System.out.println( "\nEmployee data exported to employees.txt successfully!" ) ;

        } catch( IOException e ) {

            System.out.println( "Error exporting data: " + e.getMessage( ) ) ;
        }
    }


    // Calculate salaries of all employees
    private static void calculateSalaries( ) {

        if( employees.isEmpty( ) ) {

            System.out.println( "\nNo employees to calculate salaries for." ) ;
            return ;
        }

        System.out.println( "\n--- Salaries ---" ) ;

        for( int i = 0 ; i < employees.size( ) ; i = i + 1 ) {

            Employee emp = employees.get( i ) ;

            System.out.println( emp.name + " (" + emp.id + ") → ₹" + emp.calculateSalary( ) ) ;
        }
    }


    // Main method
    public static void main( String[ ] args ) {

        while( true ) {

            System.out.println( "\n===== HR Management System =====" ) ;
            System.out.println( "1. Add Employee" ) ;
            System.out.println( "2. View Employees" ) ;
            System.out.println( "3. Search Employee by ID" ) ;
            System.out.println( "4. Update Employee Salary" ) ;
            System.out.println( "5. Delete Employee" ) ;
            System.out.println( "6. Calculate Salaries" ) ;
            System.out.println( "7. Export Employee Data" ) ;
            System.out.println( "8. Exit" ) ;
            System.out.print( "Enter your choice: " ) ;

            int option = sc.nextInt( ) ;

            switch( option ) {

                case 1 -> addEmployee( ) ;
                case 2 -> viewEmployees( ) ;
                case 3 -> searchEmployee( ) ;
                case 4 -> updateSalary( ) ;
                case 5 -> deleteEmployee( ) ;
                case 6 -> calculateSalaries( ) ;
                case 7 -> exportToFile( ) ;

                case 8 -> {
                    System.out.println( "Exiting... Goodbye!" ) ;
                    System.exit( 0 ) ;
                }

                default -> System.out.println( "Invalid choice! Try again." ) ;
            }
        }
    }
}

