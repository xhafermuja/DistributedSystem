package com.unipz.xhm.fshk.backendsystem.repository;

import com.unipz.xhm.fshk.backendsystem.dto.DepartmentDTO;
import com.unipz.xhm.fshk.backendsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT new com.unipz.xhm.fshk.backendsystem.dto.DepartmentDTO(d.departmentId, d.departmentEmri, d.departmentPershkrimi) " +
            "FROM Department d ")
    List<DepartmentDTO> findAllDepartmentsDTO();
}
