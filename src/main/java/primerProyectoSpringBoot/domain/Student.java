package primerProyectoSpringBoot.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Student {
    private UUID ID;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthdate;
    private Integer course;

    public Student(UUID ID, String name, String lastName, String email, LocalDate birthdate, Integer course) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.course = course;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(ID, student.ID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", course=" + course +
                '}';
    }
}
