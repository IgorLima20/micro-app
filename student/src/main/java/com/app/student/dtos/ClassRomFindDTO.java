package com.app.student.dtos;

import com.app.core.models.ClassRom;

public class ClassRomFindDTO {

    private int id;

    private String classname;

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

    public ClassRomFindDTO(ClassRom classrom) {
        this.id = classrom.getId();
        this.classname = classrom.getClassname();
    }

}
