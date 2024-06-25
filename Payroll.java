import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private int payrollId;
    private int employeeId;
    private YearMonth monthYear;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;

    private static List<Payroll> payrollDatabase = new ArrayList<>();
    private static int nextPayrollId = 1;

    public Payroll(int payrollId, int employeeId, YearMonth monthYear, double basicSalary, double allowances,
                   double deductions, double netSalary) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.monthYear = monthYear;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public Payroll(int employeeId2, String string, double d) {
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public YearMonth getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(YearMonth monthYear) {
        this.monthYear = monthYear;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }


    public static void addPayroll(Payroll payroll) {
        payroll.setPayrollId(nextPayrollId++);
        payrollDatabase.add(payroll);
    }

    public static Payroll getPayrollById(int payrollId) {
        for (Payroll pr : payrollDatabase) {
            if (pr.getPayrollId() == payrollId) {
                return pr;
            }
        }
        return null;
    }

    public static void updatePayroll(Payroll updatedPayroll) {
        for (Payroll pr : payrollDatabase) {
            if (pr.getPayrollId() == updatedPayroll.getPayrollId()) {
                pr.setEmployeeId(updatedPayroll.getEmployeeId());
                pr.setMonthYear(updatedPayroll.getMonthYear());
                pr.setBasicSalary(updatedPayroll.getBasicSalary());
                pr.setAllowances(updatedPayroll.getAllowances());
                pr.setDeductions(updatedPayroll.getDeductions());
                pr.setNetSalary(updatedPayroll.getNetSalary());
                return;
            }
        }
    }

    public static void deletePayroll(int payrollId) {
        Payroll payrollToRemove = null;
        for (Payroll pr : payrollDatabase) {
            if (pr.getPayrollId() == payrollId) {
                payrollToRemove = pr;
                break;
            }
        }
        if (payrollToRemove != null) {
            payrollDatabase.remove(payrollToRemove);
        }
    }

    public static List<Payroll> getAllPayrolls() {
        return payrollDatabase;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", monthYear=" + monthYear +
                ", netSalary=" + netSalary +
                '}';
    }
}
