import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get employee information
        int id = scanner.nextInt();
        String name = scanner.nextLine();
        System.out.print("Enter date of birth(dd/mm/yy) : ");
        String dateOfBirthStr = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

        String email = scanner.nextLine();
        System.out.print("Enter joining date(dd/mm/yy) : ");
        String joiningDateStr = scanner.next();
        LocalDate joiningDate = LocalDate.parse(joiningDateStr, formatter);




        // Create employee object
        Employee employee = (Calendar.getInstance().get(Calendar.YEAR) < 2023) ? new Officer(id, name, dateOfBirth, email, joiningDate) : new Staff(id, name, dateOfBirth, email, joiningDate);

        // Calculate leave days
        int vacationDays = calculateVacationDays(employee);
        int sickDays = calculateSickDays(employee);

        // Display results
        System.out.println("Vacation days: " + vacationDays);
        System.out.println("Sick days: " + sickDays);
    }





        //int daySinceJoining = currentDate.getTime() -employee.getJoiningDate().getTime();
    }
    public int calculateVacationDays(Employee employee) {
        // Get current date
        Date currentDate = new Date();

        // Calculate number of days since joining date
        var daysSinceJoining = currentDate.getTime() - employee.getJoiningDate().getTime();
        daysSinceJoining /= 1000 * 60 * 60 * 24;

        // Calculate number of days left in the year
        int daysLeftInYear = currentDate.isLeapYear() ? 366 : 365;
        daysLeftInYear -= currentDate.getDayOfYear();

        // Calculate vacation days
        int vacationDays = (daysSinceJoining + 1) * employee.getVacationDays() / daysLeftInYear;

        // Round vacation days up or down
        vacationDays = (vacationDays >= 0.5) ? (int) Math.ceil(vacationDays) : (int) Math.floor(vacationDays);

        return vacationDays;
    }

      public int calculateSickDays(Employee employee) {
        // Calculate sick days in the same way as vacation days
        int sickDays = (daysSinceJoining + 1) * employee.getSickDays() / daysLeftInYear;
        sickDays = (sickDays >= 0.5) ? (int) Math.ceil(sickDays) : (int) Math.floor(sickDays);

        return sickDays;
    }
}

