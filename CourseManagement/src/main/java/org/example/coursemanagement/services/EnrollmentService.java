package org.example.coursemanagement.services;

import org.example.coursemanagement.model.Enrollment;
import org.example.coursemanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepo;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    public Enrollment getEnrollment(Long id) {
        return enrollmentRepo.findById(id).orElseThrow();
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        enrollment.setId(id);
        return enrollmentRepo.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepo.deleteById(id);
    }
}
