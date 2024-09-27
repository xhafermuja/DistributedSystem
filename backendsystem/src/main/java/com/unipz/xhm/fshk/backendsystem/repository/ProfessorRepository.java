package com.unipz.xhm.fshk.backendsystem.repository;

import com.unipz.xhm.fshk.backendsystem.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> { }
