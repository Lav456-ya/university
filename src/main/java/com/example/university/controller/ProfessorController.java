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

import com.example.university.model.Professor;
import com.example.university.service.ProfessorJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorJpaService professorService;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{professorId}")
    public Professor getProfessorById(@PathVariable int professorId) {
        return professorService.getProfessorById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found with id " + professorId));
    }

    @PostMapping
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @PutMapping("/{professorId}")
    public Professor updateProfessor(@PathVariable int professorId, @RequestBody Professor professor) {
        return professorService.updateProfessor(professorId, professor);
    }

    @DeleteMapping("/{professorId}")
    public void deleteProfessor(@PathVariable int professorId) {
        professorService.deleteProfessor(professorId);
    }

    @GetMapping("/{professorId}/courses")
    public String getCoursesForProfessor(@PathVariable int professorId) {
        // Implement logic to fetch courses taught by a specific professor
        return "Courses taught by professor with ID " + professorId;
    }
}

