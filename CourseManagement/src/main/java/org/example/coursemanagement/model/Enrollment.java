package org.example.coursemanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long courseId;
    private LocalDate enrolledDate;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for studentId
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for courseId
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    // Getter and Setter for enrolledDate
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
    }
}
