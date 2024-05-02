package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> { }
