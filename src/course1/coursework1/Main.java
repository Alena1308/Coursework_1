package course1.coursework1;

public class Main {
    public static void main(String[] args) {
        Employee [] employees = new Employee[10];
        employees [0] = new Employee("Ivanov Ivan Ivanovich", "1", 90_000);
        employees [1] = new Employee("Lobanov Ivan Ivanovich", "2", 80_000);
        employees [2] = new Employee("Stepanov Ivan Ivanovich", "3", 65_000);
        employees [3] = new Employee("Sergeev Ivan Ivanovich", "4", 56_000);
        employees [4] = new Employee("Panevin Ivan Ivanovich", "5", 87_000);
        employees [5] = new Employee("Nemkov Ivan Ivanovich", "1", 82_000);
        employees [6] = new Employee("Levina Maria Ivanovna", "2", 100_000);
        employees [7] = new Employee("Kirova Svetlana Ivanovna", "3", 50_000);
        employees [8] = new Employee("Koshina Kira Ivanovna", "4", 92_000);
        employees [9] = new Employee("Zimina Anna Ivanovna", "5", 84_000);
        printArray(employees);
        System.out.println("Сумма затрат на зарплаты в месяц = " + getSalarySum(employees));
        System.out.println("Сотрудник с минимальной зарплатой = " + findEmployeeMinSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой = " + findEmployeeMaxSalary(employees));
        System.out.println("Среднее значение зарплат = " + findAverageSalaryValue(employees));
        printAllFullNames(employees);

    }
    public static void printArray (Employee [] array) {
        System.out.println("Список сотрудников с их данными:");
        for (int i = 0; i < array.length; i++) {
            array [i].toString();
            System.out.println(array[i]);
        }
    }
    public  static double getSalarySum (Employee [] array) {
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
        double averageSalaryValue = getSalarySum(array) / array.length;
        return averageSalaryValue;
    }
    public static void printAllFullNames (Employee [] array) {
        System.out.println("Список ФИО всех сотрудников:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getFullName());
        }
    }

}
