package com.app.core.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "classroms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String classname;

    //@JsonManagedReference
    @ManyToMany
    @JoinTable(name = "classrom_students",
               joinColumns = @JoinColumn(name = "classrom_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

}
