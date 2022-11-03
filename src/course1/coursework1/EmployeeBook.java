package course1.coursework1;

public class EmployeeBook {
    private final Employee[] employees;
    private int count;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
        count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
    }
    public void printArray() {
        System.out.println("Список сотрудников с их данными:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }
    public double findSalarySum() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }
    public Employee findEmployeeMinSalary() {
        Employee employeeMinSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() <= employeeMinSalary.getSalary()) {
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }
    public Employee findEmployeeMaxSalary() {
        Employee employeeMaxSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }
    public double findAverageSalaryValue() {
        double averageSalaryValue = findSalarySum() / count;
        return averageSalaryValue;
    }
    public void printAllFullNames() {
        System.out.println("Список ФИО всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }
    public void indexSalary(double indexPercent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                double s = employees[i].getSalary();
                s += s * indexPercent / 100;
                employees[i].setSalary(s);
            }
        }
    }
    public Employee findInDepartmentEmployeeMinSalary(int department) {
        Employee employeeMinSalary = findEmployeeMaxSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment()) && employees[i].getSalary() <= employeeMinSalary.getSalary()) {
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }
    public Employee findInDepartmentEmployeeMaxSalary(int department) {
        Employee employeeMaxSalary = findEmployeeMinSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment()) && employees[i].getSalary() >= employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }
    public double findSalaryDepartmentSum(int department) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment())) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }
    public double findAverageSalaryValueDepartment(int department) {
        double averageSalaryValueDepartment = 0;
        int countDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment())) {
                countDepartment++;
            }
            averageSalaryValueDepartment = findSalaryDepartmentSum(department) / countDepartment;
        }
        return averageSalaryValueDepartment;
    }
    public void indexSalaryDepartment(double indexPercent, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment())) {
                double s = employees[i].getSalary();
                s += s * indexPercent / 100;
                employees[i].setSalary(s);
            }
        }
    }
    public void printDepartmentEmployees(int department) {
        System.out.println("Список сотрудников отдела " + department + " с их данными:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && department == (employees[i].getDepartment())) {
                System.out.println("ID: " + employees[i].getId() + ", Full name: " + employees[i].getFullName() + ", Salary: " + employees[i].getSalary());
            }
        }
    }
    public void lessThanANumber(double number) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + number);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && number > employees[i].getSalary()) {
                Employee employeeMinSalary = employees[i];
                System.out.println("ID: " + employees[i].getId() + ", Full name: " + employees[i].getFullName() + ", Salary: " + employees[i].getSalary());
            }
        }
    }
    public void moreThanANumber(double number) {
        System.out.println("Сотрудники с зарплатой больше, чем " + number);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && number < employees[i].getSalary()) {
                Employee employeeMaxSalary = employees[i];
                System.out.println("ID: " + employees[i].getId() + ", Full name: " + employees[i].getFullName() + ", Salary: " + employees[i].getSalary());
            }
        }
    }
    public void addEmployee(String fullName, int department, double salary) {
        if (count >= employees.length) {
            System.out.println("Employee book is full. Adding a new employee is restricted.");
        } else {
            Employee newEmployee = new Employee(fullName, department, salary);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = newEmployee;
                    break;
                }
            }
        }
    }
    public void deleteEmployee(int ID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && ID == employees[i].getId()) {
                employees[i] = null;
            }
        }
    }
    public void changeSalary(String fullName, double newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && fullName.equals(employees[i].getFullName())) {
                employees[i].setSalary(newSalary);
            }
        }

    }
    public void changeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && fullName.equals(employees[i].getFullName())) {
                employees[i].setDepartment(newDepartment);
            }
        }

    }
    public void printEmployeesSortingByDepartment () {
        int [] departments = new int[5];
        int value = 1;
        for (int a = 0; a < departments.length; a++) {
            departments[a] = value;
            System.out.println("Отдел " + value + ":");
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (value == employees[i].getDepartment()) {
                        System.out.println(employees[i].getFullName());
                    }
                }
            }
            value++;
        }
    }
}

