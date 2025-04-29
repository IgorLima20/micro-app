package com.app.classrom.dtos;

import com.app.core.models.ClassRom;

import java.util.List;

public class ClassFindDTO {

    private int id;

    private String classname;

    private List<StudentFindDTO> students;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<StudentFindDTO> getStudents() {
        return this.students;
    }

    public void setStudents(List<StudentFindDTO> students) {
        this.students = students;
    }

    public ClassFindDTO(ClassRom classRom) {
        this.id = classRom.getId();
        this.classname = classRom.getClassname();
        this.students = classRom.getStudents()
                        .stream()
                        .map(StudentFindDTO::new)
                        .toList();

    }

}