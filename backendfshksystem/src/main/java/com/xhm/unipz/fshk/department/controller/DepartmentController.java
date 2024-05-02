package com.xhm.unipz.fshk.department.controller;

import com.xhm.unipz.fshk.department.model.Department;
import com.xhm.unipz.fshk.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String hello(){return "Hello from rest services";}

    @GetMapping("/getAll")
    public List<Department> getAllDepartments(){return departmentService.getAllDepartments();}

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){return departmentService.saveDepartment(department);};

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Integer departmentId, @RequestBody Department department){return departmentService.updateDepartment(departmentId,department);}

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Integer departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!.");
    }

}
