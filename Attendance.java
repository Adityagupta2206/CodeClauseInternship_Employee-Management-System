import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Attendance {
    private int attendanceId;
    private int employeeId;
    private LocalDate date;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;

    private static List<Attendance> attendanceDatabase = new ArrayList<>();
    private static int nextAttendanceId = 1;

    // Constructor
    public Attendance(int attendanceId, int employeeId, LocalDate date, LocalTime checkInTime, LocalTime checkOutTime) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public Attendance(int employeeId2, String string, boolean b) {
    }

    // Getters and setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    // CRUD Operations

    // Create (Add new attendance record)
    public static void addAttendance(Attendance attendance) {
        attendance.setAttendanceId(nextAttendanceId++);
        attendanceDatabase.add(attendance);
    }

    // Read (Retrieve attendance record by ID)
    public static Attendance getAttendanceById(int attendanceId) {
        for (Attendance att : attendanceDatabase) {
            if (att.getAttendanceId() == attendanceId) {
                return att;
            }
        }
        return null; // If attendance with given ID not found
    }

    // Update (Update attendance record details)
    public static void updateAttendance(Attendance updatedAttendance) {
        for (Attendance att : attendanceDatabase) {
            if (att.getAttendanceId() == updatedAttendance.getAttendanceId()) {
                att.setEmployeeId(updatedAttendance.getEmployeeId());
                att.setDate(updatedAttendance.getDate());
                att.setCheckInTime(updatedAttendance.getCheckInTime());
                att.setCheckOutTime(updatedAttendance.getCheckOutTime());
                return;
            }
        }
    }

    // Delete (Remove attendance record by ID)
    public static void deleteAttendance(int attendanceId) {
        Attendance attendanceToRemove = null;
        for (Attendance att : attendanceDatabase) {
            if (att.getAttendanceId() == attendanceId) {
                attendanceToRemove = att;
                break;
            }
        }
        if (attendanceToRemove != null) {
            attendanceDatabase.remove(attendanceToRemove);
        }
    }

    // Get all attendance records
    public static List<Attendance> getAllAttendance() {
        return attendanceDatabase;
    }

    // Save attendance records to a file
    public static void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(attendanceDatabase);
            System.out.println("Attendance data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load attendance records from a file
    @SuppressWarnings("unchecked")
    public static void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            attendanceDatabase = (List<Attendance>) ois.readObject();
            System.out.println("Attendance data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", employeeId=" + employeeId +
                ", date=" + date +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
