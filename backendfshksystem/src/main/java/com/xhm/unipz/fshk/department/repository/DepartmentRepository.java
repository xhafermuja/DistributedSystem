package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> { }
