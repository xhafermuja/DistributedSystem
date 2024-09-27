package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.DepartmentDTO;
import com.unipz.xhm.fshk.backendsystem.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department updateDepartment(Integer id, Department department);
    void deleteDepartment(Integer id);

    List<DepartmentDTO> findAllDepartmentsDTO();

}
