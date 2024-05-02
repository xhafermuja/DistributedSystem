package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Professor;
import com.xhm.unipz.fshk.department.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Integer professorId) {
        return professorRepository.findById(professorId).orElseThrow(()-> new ExpressionException("Message of thrown Exception"+professorId));
    }

    @Override
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
    public void deleteProfessor(Integer id) {
        Professor updateProfessor= professorRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Professor with this id do not exist: "+id));

        professorRepository.deleteById(id);
    }
}
