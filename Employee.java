import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int employeeId;
    private String name;
    private String dateOfBirth;
    private String contactNumber;
    private String address;
    private String department;
    private String position;
    private String employmentStatus;
    private String joiningDate;
    private String bankAccountNumber;
    private double salary;

   
    private List<Attendance> attendanceList;
    private List<Payroll> payrollList;

    private static List<Employee> employeeDatabase = new ArrayList<>();
    private static int nextEmployeeId = 1;

    
    public Employee(int employeeId, String name, String dateOfBirth, String contactNumber, String address,
                    String department, String position, String employmentStatus, String joiningDate,
                    String bankAccountNumber, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.address = address;
        this.department = department;
        this.position = position;
        this.employmentStatus = employmentStatus;
        this.joiningDate = joiningDate;
        this.bankAccountNumber = bankAccountNumber;
        this.salary = salary;

        this.attendanceList = new ArrayList<>();
        this.payrollList = new ArrayList<>();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public void addAttendance(Attendance attendance) {
        this.attendanceList.add(attendance);
    }

    public List<Payroll> getPayrollList() {
        return payrollList;
    }

    public void setPayrollList(List<Payroll> payrollList) {
        this.payrollList = payrollList;
    }

    public void addPayroll(Payroll payroll) {
        this.payrollList.add(payroll);
    }


    public static void addEmployee(Employee employee) {
        employee.setEmployeeId(nextEmployeeId++);
        employeeDatabase.add(employee);
    }

    public static Employee getEmployeeById(int employeeId) {
        for (Employee emp : employeeDatabase) {
            if (emp.getEmployeeId() == employeeId) {
                return emp;
            }
        }
        return null; 
    }

    public static void updateEmployee(Employee updatedEmployee) {
        for (Employee emp : employeeDatabase) {
            if (emp.getEmployeeId() == updatedEmployee.getEmployeeId()) {
                emp.setName(updatedEmployee.getName());
                emp.setDateOfBirth(updatedEmployee.getDateOfBirth());
                emp.setContactNumber(updatedEmployee.getContactNumber());
                emp.setAddress(updatedEmployee.getAddress());
                emp.setDepartment(updatedEmployee.getDepartment());
                emp.setPosition(updatedEmployee.getPosition());
                emp.setEmploymentStatus(updatedEmployee.getEmploymentStatus());
                emp.setJoiningDate(updatedEmployee.getJoiningDate());
                emp.setBankAccountNumber(updatedEmployee.getBankAccountNumber());
                emp.setSalary(updatedEmployee.getSalary());
                return;
            }
        }
    }

    public static void deleteEmployee(int employeeId) {
        Employee employeeToRemove = null;
        for (Employee emp : employeeDatabase) {
            if (emp.getEmployeeId() == employeeId) {
                employeeToRemove = emp;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeDatabase.remove(employeeToRemove);
        }
    }

    public static List<Employee> getAllEmployees() {
        return employeeDatabase;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
