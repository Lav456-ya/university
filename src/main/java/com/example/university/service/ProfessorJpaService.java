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

import com.example.university.model.Professor;
import com.example.university.repository.ProfessorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorJpaService {

    @Autowired
    private ProfessorJpaRepository professorRepository;

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(int professorId) {
        return professorRepository.findById(professorId);
    }

    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(int professorId, Professor professor) {
        Optional<Professor> existingProfessor = professorRepository.findById(professorId);
        if (existingProfessor.isPresent()) {
            professor.setProfessorId(professorId); // Ensure the ID is set
            return professorRepository.save(professor);
        }
        return null; // or throw an exception indicating professor not found
    }

    public void deleteProfessor(int professorId) {
        professorRepository.deleteById(professorId);
    }
}
