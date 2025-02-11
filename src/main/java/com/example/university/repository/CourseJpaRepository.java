/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.university.repository;

import com.example.university.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {

    List<Course> findByProfessorProfessorId(int professorId);

    List<Course> findByStudentsStudentId(int studentId);

}
