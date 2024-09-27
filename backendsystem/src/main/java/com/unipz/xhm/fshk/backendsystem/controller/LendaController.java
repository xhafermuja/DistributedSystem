package com.unipz.xhm.fshk.backendsystem.controller;

import com.unipz.xhm.fshk.backendsystem.dto.LendaProfessorDTO;
import com.unipz.xhm.fshk.backendsystem.model.Lenda;
import com.unipz.xhm.fshk.backendsystem.service.LendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lenda")
@CrossOrigin()
public class LendaController {

    @Autowired
    private LendaService lendaService;

    @GetMapping("/getAll")
    public List<Lenda> getAllLenda(){return lendaService.getAllLenda();}

    @GetMapping("/getAllLendaSD")
    public List<LendaProfessorDTO> getAllLendaSD(){return lendaService.getAllLendaSD();}

    @GetMapping("/getAllLendaTIT")
    public List<LendaProfessorDTO> getAllLendaTIT(){return lendaService.getAllLendaTIT();}

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
    public ResponseEntity<String> deleteLenda(@PathVariable("lendaId") Integer lendaId){
        lendaService.deleteLenda(lendaId);
        return ResponseEntity.ok("Lenda deleted successfully!.");
    }

}
