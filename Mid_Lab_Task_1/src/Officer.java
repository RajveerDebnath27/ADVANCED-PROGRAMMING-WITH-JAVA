import java.time.LocalDate;

public class Officer extends Employee {
    public Officer(int id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate, 15, 10);
    }

}