import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String ailment;

    public Patient(int id, String name, int age, String ailment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment;
    }
}

class Appointment {
    int appointmentId;
    int patientId;
    String doctorName;
    String date;

    public Appointment(int appointmentId, int patientId, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: " + doctorName + ", Date: " + date;
    }
}

public class HospitalManagementSystem {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static int patientIdCounter = 1;
    private static int appointmentIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Hospital Management System!");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerPatient(scanner);
                    break;
                case 2:
                    scheduleAppointment(scanner);
                    break;
                case 3:
                    viewPatients();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Hospital Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient ailment: ");
        String ailment = scanner.nextLine();

        Patient patient = new Patient(patientIdCounter++, name, age, ailment);
        patients.add(patient);
        System.out.println("Patient registered successfully: " + patient);
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(appointmentIdCounter++, patientId, doctorName, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully: " + appointment);
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            System.out.println("Registered Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
