import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PaperlessShippingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter employee details:");

            System.out.print("Employee ID (integer): ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Employee Type (Officer/Staff): ");
            String employeeType = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();
            Date dateOfBirth = parseDate(dobString);

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Joining Date (YYYY-MM-DD): ");
            String joiningDateString = scanner.nextLine();
            Date joiningDate = parseDate(joiningDateString);

            // Calculate leave days based on employee type and joining date
            int vacationLeave, sickLeave;
            if (joiningDate.compareTo(parseDate("2023-12-12")) >= 0) {
                // Employee joins on or after December 12, 2023
                vacationLeave = 1; // All employees get 1 vacation leave
                sickLeave = employeeType.equalsIgnoreCase("Officer") ? 1 : 0; // Officers get 1 sick leave, Staff get 0
            } else {
                // Employee joins before December 12, 2023
                vacationLeave = calculateLeave(joiningDate, employeeType.equalsIgnoreCase("Officer") ? 15 : 10);
                sickLeave = calculateLeave(joiningDate, employeeType.equalsIgnoreCase("Officer") ? 10 : 7);
            }

            // Display employee details and leave information
            System.out.println("\nEmployee Details:");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Employee Type: " + employeeType);
            System.out.println("Name: " + name);
            System.out.println("Date of Birth: " + dobString);
            System.out.println("Email: " + email);
            System.out.println("Joining Date: " + joiningDateString);

            System.out.println("\nLeave Information:");
            System.out.println("Vacation Leave: " + vacationLeave);
            System.out.println("Sick Leave: " + sickLeave);

            System.out.println("\n==============================\n");
        }

        scanner.close();
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please use the format YYYY-MM-DD.");
            return null;
        }
    }

    private static int calculateLeave(Date joiningDate, int totalLeaveDays) {
        Date endOfYear = parseDate("2023-12-31");
        int daysInYear = (joiningDate.getYear() % 4 == 0 && joiningDate.getYear() % 100 != 0) || (joiningDate.getYear() % 400 == 0) ? 366 : 365;

        double leaveDays = ((endOfYear.getTime() - joiningDate.getTime()) / (1000.0 * 60 * 60 * 24) + 1) * totalLeaveDays / daysInYear;

        // Adjust the condition for the specific scenario
        return leaveDays < 1 ? totalLeaveDays : (int) Math.ceil(leaveDays);
    }
}
