package com.xhm.unipz.fshk.department.controller;

import com.xhm.unipz.fshk.department.model.Semester;
import com.xhm.unipz.fshk.department.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semester")
@CrossOrigin
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping("/getAll")
    public List<Semester> getAllSemester(){return semesterService.getAllSemester();}

    @PostMapping("/save")
    public Semester saveSemester(@RequestBody Semester semester){return semesterService.saveSemester(semester);}

    @PutMapping("/{semesterId}")
    public Semester updateSemester(@PathVariable("semesterId") Integer semesterId, @RequestBody Semester semester){return semesterService.updateSemester(semesterId,semester);}

    @DeleteMapping("/{semesterId}")
    public ResponseEntity<String > deleteSemester(@PathVariable("semesterId") Integer semesterId){
        semesterService.deleteSemester(semesterId);

        return ResponseEntity.ok("Semester deleted successfully!.");
    }
}
