package org.example.coursemanagement.repository;

import org.example.coursemanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
