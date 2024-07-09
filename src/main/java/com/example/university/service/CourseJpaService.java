/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseJpaService {

    @Autowired
    private CourseJpaRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(int courseId, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            course.setCourseId(courseId); // Ensure the ID is set
            return courseRepository.save(course);
        }
        return null; // or throw an exception indicating course not found
    }

    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<Course> getCoursesByProfessorId(int professorId) {
        return courseRepository.findByProfessorProfessorId(professorId);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return courseRepository.findByStudentsStudentId(studentId);
    }
}
