package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static streams.DataProvider.getTemperatures;

class Employee {
    private int id;
    private String name;
    private String department;
    private int age;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, int age, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

class Transaction {
    private int id;
    private String date;
    private double amount;
    private String customerName;

    // Constructor
    public Transaction(int id, String date, double amount, String customerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customerName = customerName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // toString
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}

class Temperature {
    private String date;
    private double value;

    // Constructor
    public Temperature(String date, double value) {
        this.date = date;
        this.value = value;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // toString
    @Override
    public String toString() {
        return "Temperature{" +
                "date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}

class Department {
    private String name;
    private String location;

    // Constructor
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString
    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


class DataProvider {

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice Johnson", "HR", 30, 60000));
        employees.add(new Employee(2, "Bob Smith", "IT", 28, 75000));
        employees.add(new Employee(3, "Charlie Brown", "Finance", 35, 80000));
        employees.add(new Employee(4, "David Wilson", "Marketing", 40, 65000));
        employees.add(new Employee(5, "Emma Davis", "IT", 25, 72000));
        employees.add(new Employee(6, "Frank Miller", "HR", 29, 58000));
        employees.add(new Employee(7, "Grace White", "Finance", 32, 90000));
        employees.add(new Employee(8, "Hannah Lee", "IT", 27, 78000));
        employees.add(new Employee(9, "Ian Hall", "Marketing", 34, 67000));
        employees.add(new Employee(10, "Jack Adams", "Finance", 38, 95000));
        employees.add(new Employee(11, "Kelly Green", "HR", 31, 62000));
        employees.add(new Employee(12, "Liam Nelson", "IT", 26, 73000));
        employees.add(new Employee(13, "Mia Carter", "Marketing", 29, 69000));
        employees.add(new Employee(14, "Noah Wright", "Finance", 36, 88000));
        employees.add(new Employee(15, "Olivia Scott", "IT", 28, 76000));
        employees.add(new Employee(16, "Paul Baker", "HR", 33, 60000));
        employees.add(new Employee(17, "Quinn Turner", "Marketing", 30, 71000));
        employees.add(new Employee(18, "Rachel King", "Finance", 39, 93000));
        employees.add(new Employee(19, "Samuel Phillips", "IT", 27, 77000));
        employees.add(new Employee(20, "Taylor Martin", "HR", 35, 64000));
        return employees;
    }

    public static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(101, "2024-01-01", 500.75, "John Doe"));
        transactions.add(new Transaction(102, "2024-01-02", 1200.00, "Jane Smith"));
        transactions.add(new Transaction(103, "2024-01-03", 340.50, "Michael Johnson"));
        transactions.add(new Transaction(104, "2024-01-04", 890.30, "Emily Davis"));
        transactions.add(new Transaction(105, "2024-01-05", 1300.25, "Daniel Brown"));
        transactions.add(new Transaction(106, "2024-01-06", 600.80, "Sophia Wilson"));
        transactions.add(new Transaction(107, "2024-01-07", 420.15, "James Miller"));
        transactions.add(new Transaction(108, "2024-01-08", 1500.60, "Olivia Taylor"));
        transactions.add(new Transaction(109, "2024-01-09", 720.90, "William Anderson"));
        transactions.add(new Transaction(110, "2024-01-10", 980.40, "Charlotte Thomas"));
        transactions.add(new Transaction(111, "2024-01-11", 250.75, "Henry White"));
        transactions.add(new Transaction(112, "2024-01-12", 1800.50, "Lucas Harris"));
        transactions.add(new Transaction(113, "2024-01-13", 560.60, "Isabella Martin"));
        transactions.add(new Transaction(114, "2024-01-14", 900.75, "Ethan Robinson"));
        transactions.add(new Transaction(115, "2024-01-15", 1350.90, "Mia Clark"));
        transactions.add(new Transaction(116, "2024-01-16", 680.20, "Alexander Lewis"));
        transactions.add(new Transaction(117, "2024-01-17", 1190.00, "Ava Walker"));
        transactions.add(new Transaction(118, "2024-01-18", 760.80, "Benjamin Hall"));
        transactions.add(new Transaction(119, "2024-01-19", 1020.30, "Ella Allen"));
        transactions.add(new Transaction(120, "2024-01-20", 500.45, "Mason Young"));
        return transactions;
    }

    public static List<Temperature> getTemperatures() {
        List<Temperature> temperatures = new ArrayList<>();
        temperatures.add(new Temperature("2024-01-01", 22.5));
        temperatures.add(new Temperature("2024-01-02", 24.0));
        temperatures.add(new Temperature("2024-01-03", 19.8));
        temperatures.add(new Temperature("2024-01-04", 21.3));
        temperatures.add(new Temperature("2024-01-05", 23.6));
        temperatures.add(new Temperature("2024-01-06", 18.9));
        temperatures.add(new Temperature("2024-01-07", 20.4));
        temperatures.add(new Temperature("2024-01-08", 22.1));
        temperatures.add(new Temperature("2024-01-09", 25.0));
        temperatures.add(new Temperature("2024-01-10", 26.3));
        temperatures.add(new Temperature("2024-01-11", 27.5));
        temperatures.add(new Temperature("2024-01-12", 28.1));
        temperatures.add(new Temperature("2024-01-13", 29.6));
        temperatures.add(new Temperature("2024-01-14", 30.2));
        temperatures.add(new Temperature("2024-01-15", 19.5));
        temperatures.add(new Temperature("2024-01-16", 18.7));
        temperatures.add(new Temperature("2024-01-17", 21.9));
        temperatures.add(new Temperature("2024-01-18", 23.4));
        temperatures.add(new Temperature("2024-01-19", 25.8));
        temperatures.add(new Temperature("2024-01-20", 20.7));
        return temperatures;
    }

    public static List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Human Resources", "Building A"));
        departments.add(new Department("Information Technology", "Building B"));
        departments.add(new Department("Finance", "Building C"));
        departments.add(new Department("Marketing", "Building D"));
        departments.add(new Department("Operations", "Building E"));
        departments.add(new Department("Customer Service", "Building F"));
        departments.add(new Department("Research & Development", "Building G"));
        departments.add(new Department("Sales", "Building H"));
        departments.add(new Department("Logistics", "Building I"));
        departments.add(new Department("Procurement", "Building J"));
        departments.add(new Department("Legal", "Building K"));
        departments.add(new Department("Public Relations", "Building L"));
        departments.add(new Department("Business Development", "Building M"));
        departments.add(new Department("Quality Assurance", "Building N"));
        departments.add(new Department("Risk Management", "Building O"));
        departments.add(new Department("Compliance", "Building P"));
        departments.add(new Department("Security", "Building Q"));
        departments.add(new Department("Corporate Strategy", "Building R"));
        departments.add(new Department("Internal Audit", "Building S"));
        departments.add(new Department("Facilities Management", "Building T"));
        return departments;
    }


}


public class StreamOperations {
    public static void main(String[] args) {
        List<Employee> employees = DataProvider.getEmployees();
        List<Transaction> transactions = DataProvider.getTransactions();
        List<Temperature> temperatures = getTemperatures();
        List<Department> departments = DataProvider.getDepartments();


        var minEmp = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        var maxEmp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        minEmp.ifPresent(System.out::println);
        maxEmp.ifPresent(System.out::println);

        // group employees by department
        Map<String, List<Employee>> empByDepartment = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empByDepartment);

        Map<String, Long> countEmpsByDept = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Map<Boolean, List<Employee>> empsSalaryGret60000 = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000));
        System.out.println(empsSalaryGret60000);

        int[] numbers = new int[]{2, 8, 3, 5, 9, 4};
        Map<Integer, Integer> sumMap = new HashMap<>();
        int target = 10;
        Optional<int[]> result = IntStream.range(0, numbers.length)
                .filter(i -> {
                    int rem = target - numbers[i];
                    if (sumMap.containsKey(rem)) {
                        return true;
                    } else {
                        sumMap.put(numbers[i], i);
                        return false;
                    }
                }).mapToObj(i -> new int[]{sumMap.get(target - numbers[i]), i})
                .findFirst();
        result.ifPresent(res -> System.out.println(Arrays.toString(res)));
    }
}
