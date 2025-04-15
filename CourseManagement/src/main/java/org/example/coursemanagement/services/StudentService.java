package org.example.coursemanagement.services;


import org.example.coursemanagement.model.Student;
import org.example.coursemanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}

