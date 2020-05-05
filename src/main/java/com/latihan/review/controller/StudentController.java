package com.latihan.review.controller;

import com.latihan.review.model.Student;
import com.latihan.review.repo.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController
{

    @Autowired
    private StudentRepoImpl studentRepo;

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody Student student)
    {
        studentRepo.save(student);

        Map<String,String> status = new HashMap<>();
        status.put("Status","Successfully");

        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/delete-student/{name}")
    public ResponseEntity<?> deleteStudent(@RequestBody String name)
    {
        studentRepo.deleteByName(name);

        Map<String,String> status = new HashMap<>();
        status.put("Status","Successfully");

        return ResponseEntity.ok(status);
    }

    @GetMapping("/show-all-student")
    public ResponseEntity<?> showAll()
    {
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping("/show-all-student/{name}")
    public ResponseEntity<?> showByName(@PathVariable String name)
    {
        return ResponseEntity.ok(studentRepo.findByName(name));
    }

    @PutMapping("/update-student")
    public ResponseEntity<?> showByName(@RequestBody Student student)
    {
        studentRepo.update(student);

        Map<String,String> status = new HashMap<>();
        status.put("Status","Successfully");
        return ResponseEntity.ok(status);
    }

}
