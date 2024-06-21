package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.dto.LendaProfessorDTO;
import com.xhm.unipz.fshk.department.model.Lenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendaRepository extends JpaRepository<Lenda, Integer> {

    @Query("SELECT new com.xhm.unipz.fshk.department.dto.LendaProfessorDTO(l.lendaId, l.lendaTitulli, l.lendaKredi, l.lendaOraMbajtjes, " +
            "p.professorId, p.professorEmri, p.professorNrZyre, p.professorKati, p.professorEmail, p.professorOrariKonsultime, " +
            "s.semesterId, d.departmentId) " +
            "FROM Lenda l " +
            "JOIN l.ligjeruesi p " +
            "JOIN l.semester s " +
            "JOIN l.department d " +
            "WHERE d.departmentId = 1 " +
            "ORDER BY s.semesterId ASC")
    List<LendaProfessorDTO> findAllLendaSD();

    @Query("SELECT new com.xhm.unipz.fshk.department.dto.LendaProfessorDTO(l.lendaId, l.lendaTitulli, l.lendaKredi, l.lendaOraMbajtjes, " +
            "p.professorId, p.professorEmri, p.professorNrZyre, p.professorKati, p.professorEmail, p.professorOrariKonsultime, " +
            "s.semesterId, d.departmentId) " +
            "FROM Lenda l " +
            "JOIN l.ligjeruesi p " +
            "JOIN l.semester s " +
            "JOIN l.department d " +
            "WHERE d.departmentId = 2 " +
            "ORDER BY s.semesterId ASC")
    List<LendaProfessorDTO> findAllLendaTIT();



}
