package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.dto.DepartmentDTO;
import com.xhm.unipz.fshk.department.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department updateDepartment(Integer id, Department department);
    void deleteDepartment(Integer id);

    List<DepartmentDTO> findAllDepartmentsDTO();

}
