package course1.coursework1;

public class Main {
    public static void main(String[] args) {
        Employee [] employees = new Employee[10];
        employees [0] = new Employee("Ivanov Ivan Ivanovich", 1, 90_000);
        employees [1] = new Employee("Lobanov Ivan Ivanovich", 2, 80_000);
        employees [2] = new Employee("Stepanov Ivan Ivanovich", 3, 65_000);
        employees [3] = new Employee("Sergeev Ivan Ivanovich", 4, 56_000);
        employees [4] = new Employee("Panevin Ivan Ivanovich", 5, 87_000);
        employees [5] = new Employee("Nemkov Ivan Ivanovich", 1, 82_000);
        employees [6] = new Employee("Levina Maria Ivanovna", 2, 100_000);
        employees [7] = new Employee("Kirova Svetlana Ivanovna", 3, 50_000);
        employees [8] = new Employee("Koshina Kira Ivanovna", 4, 92_000);
        employees [9] = new Employee("Zimina Anna Ivanovna", 5, 84_000);
        printArray(employees);
        System.out.println("Сумма затрат на зарплаты в месяц = " + findSalarySum(employees));
        System.out.println("Сотрудник с минимальной зарплатой = " + findEmployeeMinSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой = " + findEmployeeMaxSalary(employees));
        System.out.println("Среднее значение зарплат = " + findAverageSalaryValue(employees));
        printAllFullNames(employees);
        System.out.println("===================================================================");
        indexSalary(employees,5);
        printArray(employees); // Проверка индексации зп
        System.out.println("Сотрудник с минимальной зарплатой в отделе = " + findInDepartmentEmployeeMinSalary(employees, 3));
        System.out.println("Сотрудник с максимальной зарплатой в отделе = " + findInDepartmentEmployeeMaxSalary(employees, 4));
        System.out.println("Сумма затрат на зарплаты отдела в месяц = " + findSalaryDepartmentSum(employees, 4));
        System.out.println("Среднее значение зарплат отдела = " + findAverageSalaryValueDepartment(employees,4));
        indexSalaryDepartment(employees, 10,5);
        printArray(employees); // Проверка индексации зп в отделе
        printDepartmentEmployees(employees, 5);
        lessThanANumber(employees, 60_000);
        MoreThanANumber(employees, 60_000);
    }
    // Базовая сложность:
    public static void printArray (Employee [] array) {
        System.out.println("Список сотрудников с их данными:");
        for (int i = 0; i < array.length; i++) {
            array [i].toString();
            System.out.println(array[i]);
        }
    }
    public  static double findSalarySum(Employee [] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array [i].getSalary();
        }
        return sum;
    }
    public static Employee findEmployeeMinSalary (Employee [] array) {
        Employee employeeMinSalary = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() <= employeeMinSalary.getSalary()) {
                employeeMinSalary = array[i];
            }
        }
        return employeeMinSalary;
    }
    public static Employee findEmployeeMaxSalary (Employee [] array) {
        Employee employeeMaxSalary = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() >= employeeMaxSalary.getSalary()) {
                employeeMaxSalary = array[i];
            }
        }
        return employeeMaxSalary;
    }
    public  static double findAverageSalaryValue (Employee [] array) {
        double averageSalaryValue = findSalarySum(array) / array.length;
        return averageSalaryValue;
    }
    public static void printAllFullNames (Employee [] array) {
        System.out.println("Список ФИО всех сотрудников:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getFullName());
        }
    }
    // Повышенная сложность:
    public static void indexSalary (Employee [] array, double indexPercent) {
        for (int i = 0; i < array.length; i++) {
            double s = array[i].getSalary();
            s += s * indexPercent /  100;
            array[i].setSalary(s);
        }
    }
    public static Employee findInDepartmentEmployeeMinSalary (Employee [] array, int department) {
        Employee employeeMinSalary = findEmployeeMaxSalary(array);
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment()) && array[i].getSalary() <= employeeMinSalary.getSalary()) {
                employeeMinSalary = array[i];
            }
        }
        return employeeMinSalary;
    }
    public static Employee findInDepartmentEmployeeMaxSalary (Employee [] array, int department) {
        Employee employeeMaxSalary = findEmployeeMinSalary(array);
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment()) && array[i].getSalary() >= employeeMaxSalary.getSalary()) {
                employeeMaxSalary = array[i];
            }
        }
        return employeeMaxSalary;
    }
    public  static double findSalaryDepartmentSum(Employee [] array, int department) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment())) {
                sum += array[i].getSalary();
            }
        }
        return sum;
    }
    public static double findAverageSalaryValueDepartment (Employee [] array, int department) {
        double averageSalaryValueDepartment = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment())) {
                count ++;
            }
            averageSalaryValueDepartment = findSalaryDepartmentSum(array, department) / count;
        }
        return averageSalaryValueDepartment;
    }
    public static void indexSalaryDepartment (Employee [] array, double indexPercent, int department) {
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment())) {
                double s = array[i].getSalary();
                s += s * indexPercent / 100;
                array[i].setSalary(s);
            }
        }
    }
    public static void printDepartmentEmployees (Employee [] array, int department) {
        System.out.println("Список сотрудников отдела " + department + " с их данными:");
        for (int i = 0; i < array.length; i++) {
            if (department == (array[i].getDepartment())) {
                System.out.println("ID: " + array[i].getId() + ", Full name: " + array[i].getFullName() + ", Salary: " + array[i].getSalary());
            }
        }
    }
    public static void lessThanANumber (Employee [] array, double number) {
        System.out.println("Сотрудники с зарплатой меньше, чем " + number);
        for (int i = 0; i < array.length; i++) {
            if (number > array[i].getSalary()) {
                Employee employeeMinSalary = array[i];
                System.out.println("ID: " + array[i].getId() + ", Full name: " + array[i].getFullName() + ", Salary: " + array[i].getSalary());
            }
        }
    }
    public static void MoreThanANumber (Employee [] array, double number) {
        System.out.println("Сотрудники с зарплатой больше, чем " + number);
        for (int i = 0; i < array.length; i++) {
            if (number < array[i].getSalary()) {
                Employee employeeMaxSalary = array[i];
                System.out.println("ID: " + array[i].getId() + ", Full name: " + array[i].getFullName() + ", Salary: " + array[i].getSalary());
            }
        }
    }
}
