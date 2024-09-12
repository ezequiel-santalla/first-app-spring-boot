package primerProyectoSpringBoot.controllers;

import org.springframework.web.bind.annotation.*;
import primerProyectoSpringBoot.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(UUID.randomUUID(), "Ezequiel", "Santalla", "ezequielasantalla@gmail.com", LocalDate.of(1999,8, 13), 1),
            new Student(UUID.randomUUID(), "María", "González", "maria.gonzalez@example.com", LocalDate.of(2000, 5, 23), 2),
            new Student(UUID.randomUUID(), "Lucas", "Pérez", "lucas.perez@example.com", LocalDate.of(1998, 11, 30), 3),
            new Student(UUID.randomUUID(), "Sofía", "Rodríguez", "sofia.rodriguez@example.com", LocalDate.of(2001, 2, 14), 1)
    ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email) {
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                return s;
            }
        }
        return null;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);

        return student;
    }

    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getID().equals(student.getID())) {
                s.setName(student.getName());
                s.setLastName(student.getLastName());
                s.setEmail(student.getEmail());
                s.setBirthdate(student.getBirthdate());
                s.setCourse(student.getCourse());

                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getID().equals(student.getID())) {
                if (student.getName() != null) {
                    s.setName(student.getName());
                }

                if (student.getLastName() != null) {
                    s.setLastName(student.getLastName());
                }

                if (student.getEmail() != null) {
                    s.setEmail(student.getEmail());
                }

                if (student.getBirthdate() != null) {
                    s.setBirthdate(student.getBirthdate());
                }

                if (student.getCourse() != null) {
                    s.setCourse(student.getCourse());
                }
                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable UUID id) {
        for (Student s : students) {
            if (s.getID().equals(id)) {
                students.remove(s);

                return s;
            }
        }
        return null;
    }
}
