package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> getAllDepartments();
    public Department updateDepartment(Integer id, Department department);
    public void deleteDepartment(Integer id);


}
