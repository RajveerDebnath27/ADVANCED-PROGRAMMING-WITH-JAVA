import java.util.Date;

public class Staff extends Employee {
    public Staff(int id, String name, Date dateOfBirth, String email, Date joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate, 10, 7);
    }
}