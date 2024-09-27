package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.DepartmentDTO;
import com.unipz.xhm.fshk.backendsystem.model.Department;
import com.unipz.xhm.fshk.backendsystem.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department saveDepartment(Department department) {return departmentRepository.save(department);}


    @Override
    public List<Department> getAllDepartments() {return departmentRepository.findAll();}



    @Override
    @Transactional
    public Department updateDepartment(Integer id, Department department) {
        Department updateDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Department not exist with id: " + id));

        updateDepartment.setDepartmentEmri(department.getDepartmentEmri());
        updateDepartment.setDepartmentPershkrimi(department.getDepartmentPershkrimi());

        return departmentRepository.save(updateDepartment);
    }
    @Override
    @Transactional
    public void deleteDepartment(Integer id) {
        Department deleteDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Department not exist with id: "+ id));
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> findAllDepartmentsDTO() {
        return departmentRepository.findAllDepartmentsDTO();
    }
}
