class CompanyEmployee {
    String empName;
    double salary;

    static String companyName;
    static int employeeCount;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee Count: " + employeeCount);
    }
}

public class Employee {
    public static void main(String[] args) {
        CompanyEmployee.companyName = "Bright Horizon Technologies";

        CompanyEmployee employee1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee employee2 = new CompanyEmployee("Arjun", 55000);
        CompanyEmployee employee3 = new CompanyEmployee("Karthik", 60000);

        CompanyEmployee.printCompanyInfo();
    }
}
