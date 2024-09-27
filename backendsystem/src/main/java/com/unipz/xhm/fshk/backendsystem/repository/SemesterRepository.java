package com.unipz.xhm.fshk.backendsystem.repository;

import com.unipz.xhm.fshk.backendsystem.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer>{ }
