import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.*;


public class Main {
    public void main(String[] args) {
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
        //Employee employee = (Calendar.getInstance().get(Calendar.YEAR) < 2023) ? new Officer(id, name, dateOfBirth, email, joiningDate) : new Staff(id, name, dateOfBirth, email, joiningDate);
        LocalDate currentDate = LocalDate.now();
        LocalDate employeeDateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
        LocalDate employeeJoiningDate = LocalDate.parse(joiningDateStr, formatter);

        Employee employee = (currentDate.getYear() < 2023) ?
                new Officer(id, name, employeeDateOfBirth, email, employeeJoiningDate) :
                new Staff(id, name, employeeDateOfBirth, email, employeeJoiningDate);


        // Calculate leave days
        int vacationDays = calculateVacationDays(employee);
        int sickDays = calculateSickDays(employee);

        // Display results
        System.out.println("Vacation days: " + vacationDays);
        System.out.println("Sick days: " + sickDays);
    }





        //int daySinceJoining = currentDate.getTime() -employee.getJoiningDate().getTime();
    //}
    public static int calculateVacationDays(Employee employee) {
        // Get current date
        Date currentDate = new Date();

        // Calculate number of days since joining date
        //long timeSinceJoining = currentDate.toEpochDay() - employee.getJoiningDate().toEpochDay();
        //int daysSinceJoining = (int) timeSinceJoining;

        //int daysSinceJoining = currentDate.getTime() - employee.getJoiningDate().getTime();
        //daysSinceJoining /= 1000 * 60 * 60 * 24;
        long daysSinceJoining = ChronoUnit.DAYS.between((Temporal) employee.getJoiningDate().atStartOfDay(), ((Date) currentDate).toInstant());


        // Calculate number of days left in the year
        //int daysLeftInYear = currentDate.isLeapYear() ? 366 : 365;
        //daysLeftInYear -= currentDate.getDayOfYear();

        class LeapYear {

            public static boolean isLeapYear(int year) {
                return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
            }
        }

        int currentDateYear = LocalDate.now().getYear();
        boolean isLeapYear = LeapYear.isLeapYear(currentDateYear);
        int daysLeftInYear = isLeapYear ? 366 : 365;
        daysLeftInYear -= LocalDate.now().getDayOfYear();


        // Calculate vacation days
        int vacationDays = (int) ((daysSinceJoining + 1) * employee.getVacationDays() / daysLeftInYear);

        // Round vacation days up or down
        vacationDays = (vacationDays >= 0.5) ? (int) Math.ceil(vacationDays) : (int) Math.floor(vacationDays);

        return vacationDays;

    }

      public static int calculateSickDays(Employee employee) {
        // Calculate sick days in the same way as vacation days
          //int daysSinceJoining = 0;
          Date currentDate = new Date();
          // Calculate number of days since joining date
         // int daysSinceJoining = Math.toIntExact(currentDate.getTime() - employee.getJoiningDate().getTime());
          long daysSinceJoining = ChronoUnit.DAYS.between((Temporal) employee.getJoiningDate().atStartOfDay(), ((Date) currentDate).toInstant());
          daysSinceJoining /= 1000 * 60 * 60 * 24;


          class LeapYear {

              public static boolean isLeapYear(int year) {
                  return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
              }
          }

        int currentDateYear = LocalDate.now().getYear();
        boolean isLeapYear = LeapYear.isLeapYear(currentDateYear);
        int daysLeftInYear = isLeapYear ? 366 : 365;
        daysLeftInYear -= LocalDate.now().getDayOfYear();

        int sickDays = Math.toIntExact((daysSinceJoining + 1) * employee.getSickDays() / daysLeftInYear);
        sickDays = (sickDays >= 0.5) ? (int) Math.ceil(sickDays) : (int) Math.floor(sickDays);

        return sickDays;
    }
}

