package dev.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

//import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    private Object GenerationType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Past
    private Date dateOfBirth;

    @NotNull
    private Gender gender;

    @NotBlank
    private String quota = "N/A";

    @NotBlank
    private String country = "Bangladeshi";

    // Getters and setters



}
