package dev.service;


import dev.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        // Implement logic to fetch all students from the database
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        // Implement logic to fetch a student by ID from the database
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        // Implement logic to update a student in the database

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        // Implement logic to delete a student from the database
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
