import java.util.Date;

public class Officer extends Employee {
    public Officer(int id, String name, Date dateOfBirth, String email, Date joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate, 15, 10);
    }
}