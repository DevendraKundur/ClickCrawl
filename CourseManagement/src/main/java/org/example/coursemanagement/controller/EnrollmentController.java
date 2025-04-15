package org.example.coursemanagement.controller;

import org.example.coursemanagement.model.Enrollment;
import org.example.coursemanagement.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return service.getEnrollment(id);
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return service.saveEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return service.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        service.deleteEnrollment(id);
    }
}
