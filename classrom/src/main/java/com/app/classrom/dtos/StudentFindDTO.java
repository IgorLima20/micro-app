package com.app.classrom.dtos;

import com.app.core.models.Student;

public class StudentFindDTO {

    private int id;

    private String name;

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

    public StudentFindDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

}
