/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.service.CourseJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseJpaService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable int courseId) {
        return courseService.getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
    }

    @GetMapping("/{courseId}/professor")
    public String getProfessorForCourse(@PathVariable int courseId) {
        // Implement logic to fetch professor details for a course
        return "Professor details for course with ID " + courseId;
    }

    @GetMapping("/{courseId}/students")
    public String getStudentsForCourse(@PathVariable int courseId) {
        // Implement logic to fetch students enrolled in a course
        return "Students enrolled in course with ID " + courseId;
    }
}
