package com.example.crudRapido.service;

import com.example.crudRapido.entity.Student;
import com.example.crudRapido.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //lista para listar la entidad studnet
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudents(Long id){
        return studentRepository.findById(id);
    }

    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
