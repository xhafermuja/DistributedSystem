package com.xhm.unipz.fshk.department.controller;

import com.xhm.unipz.fshk.department.dto.LendaProfessorDTO;
import com.xhm.unipz.fshk.department.model.Lenda;
import com.xhm.unipz.fshk.department.model.Professor;
import com.xhm.unipz.fshk.department.service.LendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lenda")
@CrossOrigin
public class LendaController {

    @Autowired
    private LendaService lendaService;

    @GetMapping("/getAll")
    public List<Lenda> getAllLenda(){return lendaService.getAllLenda();}

    @GetMapping("/getAllLendaWithProfessor")
    public List<LendaProfessorDTO> getAllLendaWithProfessor(){return lendaService.getLendaWithProfessor();}

    @PostMapping("/save")
    public Lenda saveLenda(@RequestBody Lenda lenda){return lendaService.saveLenda(lenda);}

    @PutMapping("/{lendaId}")
    public Lenda updateLenda(@PathVariable("lendaId") Integer lendaId, @RequestBody Lenda lenda){return lendaService.updateLenda(lendaId,lenda);}

    @PutMapping("/{lendaId}/professor/{professorId}")
    public Lenda assignProfessor(@PathVariable Integer lendaId, @PathVariable Integer professorId){
        return lendaService.assignProfessor(lendaId,professorId);
    }

    @PutMapping("/{lendaId}/semester/{semesterId}")
    public Lenda assignLenda(@PathVariable Integer lendaId, @PathVariable Integer semesterId){
        return lendaService.assignSemester(lendaId,semesterId);
    }

    @PutMapping("/{lendaId}/department/{departmentId}")
    public Lenda assignDepartment(@PathVariable Integer lendaId, @PathVariable Integer departmentId){
        return lendaService.assignDepartment(lendaId,departmentId);
    }

    @DeleteMapping("/{lendaId}")
    public ResponseEntity<String> deleteLenda(@PathVariable("lendaId") Integer departmentId){
        lendaService.deleteLenda(departmentId);
        return ResponseEntity.ok("Lenda deleted successfully!.");
    }

}
