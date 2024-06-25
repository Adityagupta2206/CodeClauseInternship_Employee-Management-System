import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystemUI extends JFrame {

    private JTextField tfName, tfDateOfBirth, tfContactNumber, tfAddress, tfDepartment, tfPosition,
            tfEmploymentStatus, tfJoiningDate, tfBankAccountNumber, tfSalary;

    private JButton btnAddEmployee, btnViewEmployees, btnUpdateEmployee, btnDeleteEmployee;
    private JButton btnAddAttendance, btnAddPayroll;
    private JTextArea taEmployeeDetails;

    private static List<Employee> employeeDatabase = new ArrayList<>();
    private static int nextEmployeeId = 1;

    public EmployeeManagementSystemUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Employee Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(14, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Name:"));
        tfName = new JTextField();
        inputPanel.add(tfName);

        inputPanel.add(new JLabel("Date of Birth:"));
        tfDateOfBirth = new JTextField();
        inputPanel.add(tfDateOfBirth);

        inputPanel.add(new JLabel("Contact Number:"));
        tfContactNumber = new JTextField();
        inputPanel.add(tfContactNumber);

        inputPanel.add(new JLabel("Address:"));
        tfAddress = new JTextField();
        inputPanel.add(tfAddress);

        inputPanel.add(new JLabel("Department:"));
        tfDepartment = new JTextField();
        inputPanel.add(tfDepartment);

        inputPanel.add(new JLabel("Position:"));
        tfPosition = new JTextField();
        inputPanel.add(tfPosition);

        inputPanel.add(new JLabel("Employment Status:"));
        tfEmploymentStatus = new JTextField();
        inputPanel.add(tfEmploymentStatus);

        inputPanel.add(new JLabel("Joining Date:"));
        tfJoiningDate = new JTextField();
        inputPanel.add(tfJoiningDate);

        inputPanel.add(new JLabel("Bank Account Number:"));
        tfBankAccountNumber = new JTextField();
        inputPanel.add(tfBankAccountNumber);

        inputPanel.add(new JLabel("Salary:"));
        tfSalary = new JTextField();
        inputPanel.add(tfSalary);

        btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        inputPanel.add(btnAddEmployee);

        btnViewEmployees = new JButton("View Employees");
        btnViewEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmployees();
            }
        });
        inputPanel.add(btnViewEmployees);

        btnUpdateEmployee = new JButton("Update Employee");
        btnUpdateEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });
        inputPanel.add(btnUpdateEmployee);

        btnDeleteEmployee = new JButton("Delete Employee");
        btnDeleteEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
        inputPanel.add(btnDeleteEmployee);

        btnAddAttendance = new JButton("Add Attendance");
        btnAddAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAttendance();
            }
        });
        inputPanel.add(btnAddAttendance);

        btnAddPayroll = new JButton("Add Payroll");
        btnAddPayroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPayroll();
            }
        });
        inputPanel.add(btnAddPayroll);

        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        taEmployeeDetails = new JTextArea(15, 60);
        taEmployeeDetails.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taEmployeeDetails);
        detailsPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void addEmployee() {
        String name = tfName.getText();
        String dateOfBirth = tfDateOfBirth.getText();
        String contactNumber = tfContactNumber.getText();
        String address = tfAddress.getText();
        String department = tfDepartment.getText();
        String position = tfPosition.getText();
        String employmentStatus = tfEmploymentStatus.getText();
        String joiningDate = tfJoiningDate.getText();
        String bankAccountNumber = tfBankAccountNumber.getText();
        double salary = Double.parseDouble(tfSalary.getText());

        Employee newEmployee = new Employee(nextEmployeeId, name, dateOfBirth, contactNumber, address, department,
                position, employmentStatus, joiningDate, bankAccountNumber, salary);

        employeeDatabase.add(newEmployee);

        taEmployeeDetails.append("Employee added:\n" + newEmployee.toString() + "\n\n");

        nextEmployeeId++;

        clearFields();
    }

    private void viewEmployees() {
        taEmployeeDetails.setText("");

        for (Employee emp : employeeDatabase) {
            taEmployeeDetails.append(emp.toString() + "\n");
        }
    }

    private void updateEmployee() {
        String input = JOptionPane.showInputDialog(this, "Enter Employee ID to Update:");
        if (input != null && !input.isEmpty()) {
            int employeeIdToUpdate = Integer.parseInt(input);

            for (Employee emp : employeeDatabase) {
                if (emp.getEmployeeId() == employeeIdToUpdate) {
                    emp.setName(tfName.getText()); 

                    taEmployeeDetails.setText("Employee updated:\n" + emp.toString() + "\n");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeIdToUpdate + " not found.");
        }
    }

    private void deleteEmployee() {
        String input = JOptionPane.showInputDialog(this, "Enter Employee ID to Delete:");
        if (input != null && !input.isEmpty()) {
            int employeeIdToDelete = Integer.parseInt(input);

            for (Employee emp : employeeDatabase) {
                if (emp.getEmployeeId() == employeeIdToDelete) {
                    employeeDatabase.remove(emp);

                    taEmployeeDetails.setText("Employee deleted:\n" + emp.toString() + "\n");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeIdToDelete + " not found.");
        }
    }

    private void addAttendance() {
        String input = JOptionPane.showInputDialog(this, "Enter Employee ID to Add Attendance:");
        if (input != null && !input.isEmpty()) {
            int employeeId = Integer.parseInt(input);

            for (Employee emp : employeeDatabase) {
                if (emp.getEmployeeId() == employeeId) {
                    Attendance attendance = new Attendance(emp.getEmployeeId(), "2024-06-25", true);
                    emp.addAttendance(attendance);

                    taEmployeeDetails.setText("Attendance added for Employee ID " + employeeId + ":\n"
                            + attendance.toString() + "\n");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeId + " not found.");
        }
    }

    private void addPayroll() {
        String input = JOptionPane.showInputDialog(this, "Enter Employee ID to Add Payroll:");
        if (input != null && !input.isEmpty()) {
            int employeeId = Integer.parseInt(input);

            for (Employee emp : employeeDatabase) {
                if (emp.getEmployeeId() == employeeId) {
                    Payroll payroll = new Payroll(emp.getEmployeeId(), "2024-06-25", 3000.0);
                    emp.addPayroll(payroll);

                    taEmployeeDetails.setText("Payroll added for Employee ID " + employeeId + ":\n"
                            + payroll.toString() + "\n");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee with ID " + employeeId + " not found.");
        }
    }

    private void clearFields() {
        tfName.setText("");
        tfDateOfBirth.setText("");
        tfContactNumber.setText("");
        tfAddress.setText("");
        tfDepartment.setText("");
        tfPosition.setText("");
        tfEmploymentStatus.setText("");
        tfJoiningDate.setText("");
        tfBankAccountNumber.setText("");
        tfSalary.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementSystemUI();
            }
        });
    }
}
