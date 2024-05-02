package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Semester;

import java.util.List;

public interface SemesterService {
    public Semester saveSemester(Semester semester);
    public List<Semester> getAllSemester();
    public Semester updateSemester(Integer id, Semester semester);
    public void deleteSemester(Integer id);

}
