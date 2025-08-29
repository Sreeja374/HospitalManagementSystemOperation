import java.util.*;

class Patient {
    int id;
    String name, dob, contact;
    public Patient(int id, String name, String dob, String contact) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", DOB: " + dob + ", Contact: " + contact;
    }
}

class Appointment {
    int appointmentId, patientId, staffId;
    String date, time, reason;
    public Appointment(int appointmentId, int patientId, int staffId, String date, String time, String reason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.staffId = staffId;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Staff ID: " + staffId +
                ", Date: " + date + ", Time: " + time + ", Reason: " + reason;
    }
}

class EHR {
    int patientId;
    String record;
    public EHR(int patientId, String record) {
        this.patientId = patientId;
        this.record = record;
    }
    public String toString() {
        return "Patient ID: " + patientId + ", Record: " + record;
    }
}

class Bill {
    int billId, patientId;
    double amount;
    String details;
    public Bill(int billId, int patientId, double amount, String details) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.details = details;
    }
    public String toString() {
        return "Bill ID: " + billId + ", Patient ID: " + patientId + ", Amount: $" + amount + ", Details: " + details;
    }
}

class InventoryItem {
    int itemId;
    String name;
    int quantity;
    public InventoryItem(int itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }
    public String toString() {
        return "Item ID: " + itemId + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class Staff {
    int staffId;
    String name, role;
    public Staff(int staffId, String name, String role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Role: " + role;
    }
}

public class HospitalManagementSystem {
    Scanner sc = new Scanner(System.in);

    List<Patient> patients = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();
    List<EHR> ehrRecords = new ArrayList<>();
    List<Bill> bills = new ArrayList<>();
    List<InventoryItem> inventory = new ArrayList<>();
    List<Staff> staffList = new ArrayList<>();

    int patientCounter = 1, appointmentCounter = 1, billCounter = 1, itemCounter = 1, staffCounter = 1;

    // Patient Registration
    void registerPatient() {
        System.out.print("Enter name: "); String name = sc.nextLine();
        System.out.print("Enter DOB (yyyy-mm-dd): "); String dob = sc.nextLine();
        System.out.print("Enter contact: "); String contact = sc.nextLine();
        patients.add(new Patient(patientCounter++, name, dob, contact));
        System.out.println("Patient registered.");
    }
    void viewPatients() {
        for (Patient p : patients) System.out.println(p);
    }

    // Staff Management
    void addStaff() {
        System.out.print("Enter staff name: "); String name = sc.nextLine();
        System.out.print("Enter role: "); String role = sc.nextLine();
        staffList.add(new Staff(staffCounter++, name, role));
        System.out.println("Staff added.");
    }
    void viewStaff() {
        for (Staff s : staffList) System.out.println(s);
    }

    // Appointment Scheduling
    void scheduleAppointment() {
        System.out.print("Enter patient ID: "); int pid = sc.nextInt(); sc.nextLine();
        System.out.print("Enter staff ID: "); int sid = sc.nextInt(); sc.nextLine();
        System.out.print("Enter date (yyyy-mm-dd): "); String date = sc.nextLine();
        System.out.print("Enter time (hh:mm): "); String time = sc.nextLine();
        System.out.print("Enter reason: "); String reason = sc.nextLine();
        appointments.add(new Appointment(appointmentCounter++, pid, sid, date, time, reason));
        System.out.println("Appointment scheduled.");
    }
    void viewAppointments() {
        for (Appointment a : appointments) System.out.println(a);
    }

    // Electronic Health Records (EHR)
    void addEHR() {
        System.out.print("Enter patient ID: "); int pid = sc.nextInt(); sc.nextLine();
        System.out.print("Enter record: "); String rec = sc.nextLine();
        ehrRecords.add(new EHR(pid, rec));
        System.out.println("EHR added.");
    }
    void viewEHR() {
        for (EHR e : ehrRecords) System.out.println(e);
    }

    // Billing and Invoicing
    void createBill() {
        System.out.print("Enter patient ID: "); int pid = sc.nextInt(); sc.nextLine();
        System.out.print("Enter amount: "); double amt = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter details: "); String det = sc.nextLine();
        bills.add(new Bill(billCounter++, pid, amt, det));
        System.out.println("Bill created.");
    }
    void viewBills() {
        for (Bill b : bills) System.out.println(b);
    }

    // Inventory Management
    void addInventoryItem() {
        System.out.print("Enter item name: "); String name = sc.nextLine();
        System.out.print("Enter quantity: "); int qty = sc.nextInt(); sc.nextLine();
        inventory.add(new InventoryItem(itemCounter++, name, qty));
        System.out.println("Item added to inventory.");
    }
    void viewInventory() {
        for (InventoryItem i : inventory) System.out.println(i);
    }

    void menu() {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Patient Registration");
            System.out.println("2. Staff Management");
            System.out.println("3. Appointment Scheduling");
            System.out.println("4. Electronic Health Records (EHR)");
            System.out.println("5. Billing and Invoicing");
            System.out.println("6. Inventory Management");
            System.out.println("7. Exit");
            System.out.print("Choose a module: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. Register Patient\n2. View Patients"); int pch = sc.nextInt(); sc.nextLine();
                    if (pch == 1) registerPatient(); else viewPatients();
                    break;
                case 2:
                    System.out.println("1. Add Staff\n2. View Staff"); int sch = sc.nextInt(); sc.nextLine();
                    if (sch == 1) addStaff(); else viewStaff();
                    break;
                case 3:
                    System.out.println("1. Schedule Appointment\n2. View Appointments"); int ach = sc.nextInt(); sc.nextLine();
                    if (ach == 1) scheduleAppointment(); else viewAppointments();
                    break;
                case 4:
                    System.out.println("1. Add EHR\n2. View EHRs"); int ech = sc.nextInt(); sc.nextLine();
                    if (ech == 1) addEHR(); else viewEHR();
                    break;
                case 5:
                    System.out.println("1. Create Bill\n2. View Bills"); int bch = sc.nextInt(); sc.nextLine();
                    if (bch == 1) createBill(); else viewBills();
                    break;
                case 6:
                    System.out.println("1. Add Inventory Item\n2. View Inventory"); int ich = sc.nextInt(); sc.nextLine();
                    if (ich == 1) addInventoryItem(); else viewInventory();
                    break;
                case 7:
                    System.out.println("Exiting System.");
                    return;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }

    public static void main(String[] args) {
        new HospitalManagementSystem().menu();
    }
}