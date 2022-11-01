package course1.coursework1;

public class Employee {
    private String fullName;
    private String department;
    private double salary;
    private static int count = 1;
    private int id;
    public Employee (String fullName, String department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = count;
        count ++;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "id: " + id + ", fullname: " + fullName + ", department: " + department + ", salary: " + salary;
    }
}
