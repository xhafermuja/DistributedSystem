package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.model.Lenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendaRepository extends JpaRepository<Lenda, Integer> { }
