package com.app.student.controllers;

import com.app.core.models.Student;
import com.app.student.dtos.StudentFindDTO;
import com.app.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentFindDTO>> findAll() {
        List<Student> students = studentService.findAll();
        List<StudentFindDTO> studentDTOS = students.stream()
                                           .map(StudentFindDTO::new)
                                           .toList();
        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentFindDTO> findById(@PathVariable int id) {
        StudentFindDTO studentDTO = new StudentFindDTO(studentService.findById(id));
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentFindDTO> save(@RequestBody Student student) {
        StudentFindDTO studentDTO = new StudentFindDTO(studentService.save(student));
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

}
