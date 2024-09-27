package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.model.Semester;

import java.util.List;

public interface SemesterService {
    Semester saveSemester(Semester semester);
    List<Semester> getAllSemester();
    Semester updateSemester(Integer id, Semester semester);
    void deleteSemester(Integer id);

}
