class student{
    private String studentName;
    private String studentID;
    private String courseEnrolled;
    private String enrollmentDate;
    private String courseDuration;
    private double courseFee;
    private String contactEmail;

    public student(String studentName, String studentID, String courseEnrolled, String enrollmentDate, String courseDuration, double courseFee, String contactEmail) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.courseEnrolled = courseEnrolled;
        this.enrollmentDate = enrollmentDate;
        this.courseDuration = courseDuration;
        this.courseFee = courseFee;
        this.contactEmail = contactEmail;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getCourseEnrolled() {
        return courseEnrolled;
    }
    public String getEnrollmentDate() {
        return enrollmentDate;
    }
    public String getCourseDuration() {
        return courseDuration;
    }
    public double getCourseFee() {
        return courseFee;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void displayStudentDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Course Enrolled: " + courseEnrolled);
        System.out.println("Enrollment Date: " + enrollmentDate);
        System.out.println("Course Duration: " + courseDuration);
        System.out.println("Course Fee: Rupees " + courseFee);
        System.out.println("Contact Email: " + contactEmail);
    }
    public class StudentApp {
        public static void main(String[] args) {
            student student1 = new student("Tanya", "S11330", "Computer Science", "2024-01-15", "4 years", 500000.00, "tanya.mehta@gmail.com");
            student1.displayStudentDetails();

            student student2 = new student("Raj", "S10122", "Mechanical Engineering", "2024-02-20", "4 years", 450000.00, "rajaryan@gmail.com");
            student2.displayStudentDetails();

        }
    }
}



        
