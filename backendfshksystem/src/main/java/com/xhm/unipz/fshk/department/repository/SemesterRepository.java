package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer>{ }
