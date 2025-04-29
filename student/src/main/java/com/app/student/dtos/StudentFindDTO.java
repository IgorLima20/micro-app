package com.app.student.dtos;

import com.app.core.models.Student;

import java.util.List;

public class StudentFindDTO {

    private int id;

    private String name;

    private List<ClassRomFindDTO> classroms;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassRomFindDTO> getClassroms() {
        return this.classroms;
    }

    public void setClassroms(List<ClassRomFindDTO> classroms) {
        this.classroms = classroms;
    }

    public StudentFindDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        if (student.getClassRoms() == null) {
            this.classroms = null;
        } else {
            this.classroms = student.getClassRoms()
                             .stream()
                             .map(ClassRomFindDTO::new)
                             .toList();
        }
    }

}
