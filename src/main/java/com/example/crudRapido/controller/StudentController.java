package com.example.crudRapido.controller;

import com.example.crudRapido.entity.Student;
import com.example.crudRapido.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/v1/students")
@CrossOrigin(origins = "http://localhost:3000") // Cambia esto al origen de tu frontend
public class StudentController {

    @Autowired
    private  StudentService studentService;

    // Exponer servicio
    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @PostMapping
    public void saveUpdate(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudents(studentId);
    }
}