package org.example.coursemanagement.controller;

import org.example.coursemanagement.model.Course;
import org.example.coursemanagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService services;

    @GetMapping
    public List<Course> getAll() {
        return services.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return services.getCourse(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return services.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return services.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        services.deleteCourse(id);
    }
}