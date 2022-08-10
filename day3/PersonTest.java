package day3;

class Person {
     private String name;
     private String address;
     private String phoneNum;
     private String emailAddress;
     public Person(){}

     public Person(String name, String address, String phone, String email){
        this.name = name;
        this.address = address;
        this.phoneNum = phone;
        this.emailAddress = email;
    }
    public String toString(){
         return "class name: "+this.getClass().getName()+"\t\tperson name: "+this.name;
    }
}
enum status {
    freshman, sophomore, junior, senior
}
class Student extends Person{
    private status classStatus;
    public Student(){ };
    public Student(String name, String address, String phone, String email,status CLASS_STATUS){
        super(name, address, phone, email);
        this.classStatus=CLASS_STATUS;
    }
    public String toString(){
        return super.toString();
    }
}
class Employee extends Person {
    private String office;
    private String salary;
    private String dateHired;
    public Employee(){
    }

    public Employee(String name, String address, String phone, String email,String office, String salary,String DATE_HIRED){
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = DATE_HIRED;
    }

    public String toString(){
        return super.toString();
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;
    public Faculty(){
    }

    public Faculty(String name, String address, String phone, String email,String office, String salary,String DATE_HIRED,String office_hours, String rank){
        super(name, address, phone, email,office, salary,DATE_HIRED);
        this.officeHours = office_hours;
        this.rank = rank;
    }
    public String toString(){
        return super.toString();
    }
}
class Staff extends Employee{
    private String title;
    public Staff(){
    }

    public Staff(String name, String address, String phone, String email,String office, String salary,String DATE_HIRED,String title){
        super(name, address, phone, email,office, salary,DATE_HIRED);
        this.title = title;
    }

    public String toString(){
        return super.toString();
    }

}
public class PersonTest {
    // Main method
    public static void main(String[] args) {
        // Create a Person, Student, Employee, Faculty, and Staff objects
        Person person = new Person("person_name","address1","phone1","email1");

        Student student = new Student("student_name","address1","phone1","email1",status.freshman);

        Employee employee = new Employee("employee_name","address1","phone1","email1","office1", "salary1","DATE_HIRED1");

        Faculty faculty = new Faculty("faculty_name", "address","phone", "email","office", "salary","DATE_HIRED","office_hours", "rank");

        Staff staff = new Staff("staff_name", "address","phone", "email","office", "salary","DATE_HIRED","title");

        // Invoke toString of Person, Student, Employee, Faculty and Staff
        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());
    }
}