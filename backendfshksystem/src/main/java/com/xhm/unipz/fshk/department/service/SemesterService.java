package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Semester;

import java.util.List;

public interface SemesterService {
    Semester saveSemester(Semester semester);
    List<Semester> getAllSemester();
    Semester updateSemester(Integer id, Semester semester);
    void deleteSemester(Integer id);

}
