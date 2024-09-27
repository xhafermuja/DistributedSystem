package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.LendaProfessorDTO;
import com.unipz.xhm.fshk.backendsystem.model.Department;
import com.unipz.xhm.fshk.backendsystem.model.Lenda;
import com.unipz.xhm.fshk.backendsystem.model.Professor;
import com.unipz.xhm.fshk.backendsystem.model.Semester;
import com.unipz.xhm.fshk.backendsystem.repository.DepartmentRepository;
import com.unipz.xhm.fshk.backendsystem.repository.LendaRepository;
import com.unipz.xhm.fshk.backendsystem.repository.ProfessorRepository;
import com.unipz.xhm.fshk.backendsystem.repository.SemesterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LendaServiceImpl implements LendaService{
    @Autowired
    private LendaRepository lendaRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Lenda saveLenda(Lenda lenda) {return lendaRepository.save(lenda);}

    @Override
    public List<Lenda> getAllLenda() {return lendaRepository.findAll();}

    @Override
    public List<LendaProfessorDTO> getAllLendaSD() {
        return lendaRepository.findAllLendaSD();
    }

    @Override
    public List<LendaProfessorDTO> getAllLendaTIT() {
        return lendaRepository.findAllLendaTIT();
    }


    @Override
    @Transactional
    public Lenda updateLenda(Integer id, Lenda lenda) {
        Lenda updateLenda= lendaRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Lenda not exist with this id: "+ id));

        updateLenda.setLendaTitulli(lenda.getLendaTitulli());
        updateLenda.setLendaKredi(lenda.getLendaKredi());
        updateLenda.setLendaOraMbajtjes(lenda.getLendaOraMbajtjes());


        return lendaRepository.save(updateLenda);
    }

    @Override
    @Transactional
    public Lenda assignProfessor(Integer lendaId, Integer professorId) {
        Lenda lenda= lendaRepository.findById(lendaId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ lendaId));
        Professor professor= professorRepository.findById(professorId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ professorId));
        lenda.setLigjeruesi(professor);

        return lendaRepository.save(lenda);
    }

    @Override
    @Transactional
    public Lenda assignSemester(Integer lendaId, Integer semesterId){
        Lenda lenda= lendaRepository.findById(lendaId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ lendaId));
        Semester semester= semesterRepository.findById(semesterId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ semesterId));

        lenda.setSemester(semester);
        return lendaRepository.save(lenda);
    }

    @Override
    @Transactional
    public Lenda assignDepartment(Integer lendaId, Integer departmentId){
        Lenda lenda= lendaRepository.findById(lendaId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ lendaId));
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(()->new ExpressionException("Lenda not exist with this id: "+ departmentId));

        lenda.setDepartment(department);

        return lendaRepository.save(lenda);
    }

    @Override
    @Transactional
    public void deleteLenda(Integer id) {
        Optional<Lenda> lendaOptional= lendaRepository.findById(id);

        if(lendaOptional.isPresent()){
            Lenda deleteLenda= lendaOptional.get();

            deleteLenda.setLigjeruesi(null);
            deleteLenda.setSemester(null);
            deleteLenda.setDepartment(null);

            lendaRepository.save(deleteLenda);
            lendaRepository.deleteById(id);
        }

    }
}
