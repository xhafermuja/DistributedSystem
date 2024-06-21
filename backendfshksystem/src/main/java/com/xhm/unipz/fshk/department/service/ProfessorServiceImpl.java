package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Department;
import com.xhm.unipz.fshk.department.model.Professor;
import com.xhm.unipz.fshk.department.repository.DepartmentRepository;
import com.xhm.unipz.fshk.department.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    @Transactional
    @Override
    public Professor getProfessorById(Integer professorId) {
        return professorRepository.findById(professorId).orElseThrow(()-> new ExpressionException("Message of thrown Exception"+professorId));
    }

    @Override
    @Transactional
    public Professor updateProfessor(Integer id, Professor professor) {
        Professor updateProfessor= professorRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Professor with this id do not exist: "+id));

        updateProfessor.setProfessorEmri(professor.getProfessorEmri());
        updateProfessor.setProfessorEmail(professor.getProfessorEmail());
        updateProfessor.setProfessorKati(professor.getProfessorKati());
        updateProfessor.setProfessorNrZyre(professor.getProfessorNrZyre());
        updateProfessor.setProfessorOrariKonsultime(professor.getProfessorOrariKonsultime());
        updateProfessor.setLendetLigj(professor.getLendetLigj());

        return professorRepository.save(updateProfessor);
    }

    @Override
    @Transactional
    public Professor assignDepartment(Integer professorId, Integer departmentId) {
        Professor professor= professorRepository.findById(professorId)
                .orElseThrow(()-> new ExpressionException("Professor do not exist with this id: "+professorId));
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ExpressionException("Department do not exist with this id: "+departmentId));

        professor.setDepartment(department);

        return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public void deleteProfessor(Integer id) {
        Professor updateProfessor= professorRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Professor with this id do not exist: "+id));

        professorRepository.deleteById(id);
    }
}
