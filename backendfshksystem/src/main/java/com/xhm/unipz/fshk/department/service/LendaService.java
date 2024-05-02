package com.xhm.unipz.fshk.department.service;

import com.xhm.unipz.fshk.department.model.Lenda;

import java.util.List;

public interface LendaService {
    public Lenda saveLenda(Lenda lenda);
    public List<Lenda> getAllLenda();
    public Lenda updateLenda(Integer id, Lenda lenda);
    public Lenda assignProfessor(Integer lendaId, Integer professorId);
    public Lenda assignSemester(Integer lendaId, Integer semesterId);
    public void deleteLenda(Integer id);
}
