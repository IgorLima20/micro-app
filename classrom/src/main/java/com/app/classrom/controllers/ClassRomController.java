package com.app.classrom.controllers;

import com.app.classrom.dtos.ClassFindDTO;
import com.app.classrom.dtos.ClassStudentCreateDTO;
import com.app.classrom.services.ClassRomService;
import com.app.core.models.ClassRom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("classrom")
public class ClassRomController {

    @Autowired
    private ClassRomService classRomService;

    @GetMapping
    public ResponseEntity<List<ClassFindDTO>> findAll() {
        List<ClassRom> classRoms = this.classRomService.findAll();
        List<ClassFindDTO> classFindDTOS = classRoms.stream()
                                          .map(ClassFindDTO::new)
                                          .toList();
        return new ResponseEntity<>(classFindDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassFindDTO> save(@RequestBody ClassRom classRom) {
        ClassFindDTO classDTO = new ClassFindDTO(this.classRomService.save(classRom));
        return new ResponseEntity<>(classDTO, HttpStatus.CREATED);
    }

    @PostMapping("/student")
    public ResponseEntity<ClassFindDTO> savaStudent(@RequestBody ClassStudentCreateDTO classStudent) {
        ClassFindDTO classDTO = new ClassFindDTO(this.classRomService.saveStudent(classStudent));
        return new ResponseEntity<>(classDTO, HttpStatus.CREATED);
    }

}
