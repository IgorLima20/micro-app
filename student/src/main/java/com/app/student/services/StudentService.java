package com.app.student.services;

import com.app.core.models.Student;
import com.app.core.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() { return  studentRepository.findAll(); }

    public Student findById(int id) {
        return studentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Falha ao localizar estudante."));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}
