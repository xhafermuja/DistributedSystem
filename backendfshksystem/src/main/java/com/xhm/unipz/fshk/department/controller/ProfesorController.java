package com.xhm.unipz.fshk.department.controller;

import com.xhm.unipz.fshk.department.model.Professor;
import com.xhm.unipz.fshk.department.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfesorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/getAll")
    private List<Professor> getAllProfessor(){return professorService.getAllProfessor();}

    @GetMapping("/{professorId}")
    private Professor getProfessorById(@PathVariable Integer professorId){return professorService.getProfessorById(professorId);}

    @PostMapping("/save")
    private Professor saveProfessor(@RequestBody Professor professor){return professorService.saveProfessor(professor);}

    @PutMapping("/{professorId}")
    private Professor updateProfessor(@PathVariable("professorId") Integer professorId, @RequestBody Professor professor){return professorService.updateProfessor(professorId,professor);}

    @DeleteMapping("/{professorId}")
    private ResponseEntity<String > deleteProfessor(@PathVariable("professorId") Integer professorId){
        professorService.deleteProfessor(professorId);

        return  ResponseEntity.ok("Professor deleted successfully!.");
    }
}
