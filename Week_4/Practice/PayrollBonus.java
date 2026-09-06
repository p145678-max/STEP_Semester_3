class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }

    void printSalary() {
        System.out.println(name + " | Final Salary: " + salary);
    }
}

public class PayrollBonus {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Ravi", 40000),
            new Employee("Meera", 55000),
            new Employee("Karthik", 62000),
            new Employee("Divya", 48000)
        };

        for (Employee employee : employees) {
            employee.raiseSalary(5000);
            employee.printSalary();
        }
    }
}
