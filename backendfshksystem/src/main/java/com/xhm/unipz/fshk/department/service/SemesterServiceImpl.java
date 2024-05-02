package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Semester;
import com.xhm.unipz.fshk.department.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService{
    @Autowired
    private SemesterRepository semesterRepository;


    @Override
    public Semester saveSemester(Semester semester) {return semesterRepository.save(semester);}

    @Override
    public List<Semester> getAllSemester() {return semesterRepository.findAll();}

    @Override
    public Semester updateSemester(Integer id, Semester semester) {
        Semester updateSemester= semesterRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Semester with this ID do not exist: "+id));

        updateSemester.setSemesterTitulli(semester.getSemesterTitulli());
        updateSemester.setLendet(semester.getLendet());

        return semesterRepository.save(updateSemester);
    }
    @Override
    public void deleteSemester(Integer id) {
        Semester updateSemester= semesterRepository.findById(id)
                .orElseThrow(()-> new ExpressionException("Semester with this ID do not exist: "+id));

        semesterRepository.deleteById(id);
    }
}
