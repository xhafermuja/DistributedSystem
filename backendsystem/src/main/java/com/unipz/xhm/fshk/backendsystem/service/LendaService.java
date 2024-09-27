package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.LendaProfessorDTO;
import com.unipz.xhm.fshk.backendsystem.model.Lenda;

import java.util.List;

public interface LendaService {
    Lenda saveLenda(Lenda lenda);
    List<Lenda> getAllLenda();
    List<LendaProfessorDTO> getAllLendaSD();
    List<LendaProfessorDTO> getAllLendaTIT();
    Lenda updateLenda(Integer id, Lenda lenda);
    Lenda assignProfessor(Integer lendaId, Integer professorId);
    Lenda assignSemester(Integer lendaId, Integer semesterId);
    Lenda assignDepartment(Integer lendaId, Integer departmentId);
    void deleteLenda(Integer id);
}
