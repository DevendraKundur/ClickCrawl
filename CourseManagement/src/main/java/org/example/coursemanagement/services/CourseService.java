package org.example.coursemanagement.services;

import org.example.coursemanagement.model.Course;
import org.example.coursemanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourse(Long id) {
        return courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        course.setId(id);
        return courseRepo.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
