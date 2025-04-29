package com.app.classrom.services;

import com.app.classrom.clients.StudentClient;
import com.app.classrom.dtos.ClassFindDTO;
import com.app.classrom.dtos.ClassStudentCreateDTO;
import com.app.classrom.dtos.StudentFindDTO;
import com.app.core.models.ClassRom;
import com.app.core.models.Student;
import com.app.core.repositories.ClassRomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRomService {

    @Autowired
    private ClassRomRepository classRomRepository;

    @Autowired
    private StudentClient studentClient;

    public List<ClassRom> findAll() {   return classRomRepository.findAll();   }

    public ClassRom findById(Integer id) {
        return this.classRomRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Falha ao localizar sala de aula."));
    }

    public ClassRom save(ClassRom classRom) { return classRomRepository.save(classRom); }

    public ClassRom saveStudent(ClassStudentCreateDTO classStudentCreateDTO) {
        ClassRom classRom = this.findById(classStudentCreateDTO.getIdClass());
        Student student = this.studentClient.getStudentById(classStudentCreateDTO.getIdStudent());
        classRom.getStudents().add(student);
        return this.classRomRepository.save(classRom);
    }

}
