import java.util.LinkedList;

class Employee {
    private int employeeID;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeID, String name, String position, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeHashTable {
    private LinkedList<Employee>[] table;
    private int capacity;

    public EmployeeHashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int employeeID) {
        return Math.abs(employeeID % capacity);
    }

    public Employee search(int employeeID) {
        int index = hash(employeeID);
        LinkedList<Employee> bucket = table[index];

        for (Employee emp : bucket) {
            if (emp.getEmployeeID() == employeeID) {
                return emp;
            }
        }

        return null;
    }

    public void insert(Employee employee) {
        int employeeID = employee.getEmployeeID();
        int index = hash(employeeID);
        LinkedList<Employee> bucket = table[index];

        for (Employee emp : bucket) {
            if (emp.getEmployeeID() == employeeID) {
                System.out.println("Employee with ID " + employeeID + " already exists.");
                return;
            }
        }

        bucket.add(employee);
        System.out.println("Employee with ID " + employeeID + " added successfully.");
    }

    public void delete(int employeeID) {
        int index = hash(employeeID);
        LinkedList<Employee> bucket = table[index];

        for (Employee emp : bucket) {
            if (emp.getEmployeeID() == employeeID) {
                bucket.remove(emp);
                System.out.println("Employee with ID " + employeeID + " deleted successfully.");
                return;
            }
        }

        System.out.println("Employee with ID " + employeeID + " not found.");
    }
}

public class Company {
    public static void main(String[] args) {
        EmployeeHashTable employeeTable = new EmployeeHashTable(10);

        Employee emp1 = new Employee(101, "John Doe", "Manager", 5000.0);
        Employee emp2 = new Employee(102, "Jane Smith", "Developer", 4000.0);
        Employee emp3 = new Employee(103, "Mike Johnson", "Designer", 4500.0);

        // Insert employees by their employeeID
        employeeTable.insert(emp1);
        employeeTable.insert(emp2);
        employeeTable.insert(emp3);

        // Search employee by ID
        Employee foundEmployee = employeeTable.search(102);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete employee by ID
        employeeTable.delete(102);

        // Try to find the deleted employee
        foundEmployee = employeeTable.search(102);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }
    }
}





