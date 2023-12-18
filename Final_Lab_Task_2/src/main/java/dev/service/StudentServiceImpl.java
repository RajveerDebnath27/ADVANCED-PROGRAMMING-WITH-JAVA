package dev.service;

import ch.qos.logback.classic.Level;
import dev.domain.Student;
import dev.repository.StudentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentServiceImpl implements StudentService {



    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById((long) id).orElse(null);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById((long) id);
    }

    @Override
    @Transactional
    public void registerStudent(Student student) {
        // Additional logic if needed
        studentRepository.save(student);

        Logger logger;
        Logger.getAnonymousLogger();


        //System.out.println("Student registered: " + student);
    }
}

