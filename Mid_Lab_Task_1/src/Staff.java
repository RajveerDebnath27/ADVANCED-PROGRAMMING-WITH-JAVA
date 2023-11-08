import java.time.LocalDate;

public class Staff extends Employee {
    public Staff(int id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate, 10, 7);
    }
}