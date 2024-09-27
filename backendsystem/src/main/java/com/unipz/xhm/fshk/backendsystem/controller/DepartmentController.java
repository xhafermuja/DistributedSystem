package com.unipz.xhm.fshk.backendsystem.controller;

import com.unipz.xhm.fshk.backendsystem.dto.DepartmentDTO;
import com.unipz.xhm.fshk.backendsystem.model.Department;
import com.unipz.xhm.fshk.backendsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin()
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/v1/getAll")
    public List<Department> getAllDepartments(){return departmentService.getAllDepartments();}

    @GetMapping("/v2/getAll")
    public  List<DepartmentDTO> getAllDepartmentsDTO(){return departmentService.findAllDepartmentsDTO();}

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){return departmentService.saveDepartment(department);}

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Integer departmentId, @RequestBody Department department){return departmentService.updateDepartment(departmentId,department);}

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Integer departmentId){
        departmentService.deleteDepartment(departmentId);
//        return ResponseEntity.ok("Department deleted successfully!.");
    }

}
