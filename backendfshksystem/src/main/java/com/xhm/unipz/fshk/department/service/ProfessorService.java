package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Professor;

import java.util.List;

public interface ProfessorService {

    Professor saveProfessor(Professor professor);
    List<Professor> getAllProfessor();
    Professor getProfessorById(Integer professorId);
    Professor updateProfessor(Integer id, Professor professor);
    Professor assignDepartment(Integer professorId, Integer departmentId);
    void deleteProfessor(Integer id);
}
