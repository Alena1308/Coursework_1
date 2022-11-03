package course1.coursework1;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private static int count = 1;
    private int id;
    public Employee (String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = count;
        count ++;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
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
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Full name: " + fullName + ", Department: " + department + ", Salary: " + salary;
    }
}
