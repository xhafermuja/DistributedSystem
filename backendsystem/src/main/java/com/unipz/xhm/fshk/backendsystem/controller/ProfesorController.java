package com.unipz.xhm.fshk.backendsystem.controller;

import com.unipz.xhm.fshk.backendsystem.model.Professor;
import com.unipz.xhm.fshk.backendsystem.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@CrossOrigin
public class ProfesorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/getAll")
    private List<Professor> getAllProfessor(){return professorService.getAllProfessor();}

//    @GetMapping("/getAllStafi")
//    private List<StafiDTO> getAllProfessorDTO(){return professorService.getAllProfessorDTO();}

    @GetMapping("/{professorId}")
    private Professor getProfessorById(@PathVariable Integer professorId){return professorService.getProfessorById(professorId);}

    @PostMapping("/save")
    private Professor saveProfessor(@RequestBody Professor professor){return professorService.saveProfessor(professor);}

    @PutMapping("/{professorId}")
    private Professor updateProfessor(@PathVariable("professorId") Integer professorId, @RequestBody Professor professor){return professorService.updateProfessor(professorId,professor);}

    @PutMapping("/{professorId}/department/{departmentId}")
    private Professor assignDepartment(@PathVariable Integer professorId, @PathVariable Integer departmentId){return professorService.assignDepartment(professorId,departmentId);}

    @DeleteMapping("/{professorId}")
    private ResponseEntity<String> deleteProfessor(@PathVariable("professorId") Integer professorId){
        professorService.deleteProfessor(professorId);
        return  ResponseEntity.ok("Professor deleted successfully!.");
    }
}
