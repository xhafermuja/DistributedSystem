package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Professor;

import java.util.List;

public interface ProfessorService {

    public Professor saveProfessor(Professor professor);
    public List<Professor> getAllProfessor();
    public Professor getProfessorById(Integer professorId);
    public Professor updateProfessor(Integer id, Professor professor);
    public void deleteProfessor(Integer id);
}
