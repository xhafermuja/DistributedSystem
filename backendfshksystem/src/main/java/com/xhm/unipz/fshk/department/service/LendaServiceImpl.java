package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.dto.LendaProfessorDTO;
import com.xhm.unipz.fshk.department.model.Department;
import com.xhm.unipz.fshk.department.model.Lenda;
import com.xhm.unipz.fshk.department.model.Professor;
import com.xhm.unipz.fshk.department.model.Semester;
import com.xhm.unipz.fshk.department.repository.DepartmentRepository;
import com.xhm.unipz.fshk.department.repository.LendaRepository;
import com.xhm.unipz.fshk.department.repository.ProfessorRepository;
import com.xhm.unipz.fshk.department.repository.SemesterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Lenda deleteLenda= lendaRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Department not exist with id: "+ id));

        lendaRepository.deleteById(id);
    }
}
