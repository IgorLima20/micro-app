package com.app.classrom.clients;

import com.app.core.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("student")
public interface StudentClient {

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable("id") int id);

}
