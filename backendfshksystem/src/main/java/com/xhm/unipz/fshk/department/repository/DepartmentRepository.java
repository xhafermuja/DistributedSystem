package com.xhm.unipz.fshk.department.repository;

import com.xhm.unipz.fshk.department.dto.DepartmentDTO;
import com.xhm.unipz.fshk.department.dto.LendaProfessorDTO;
import com.xhm.unipz.fshk.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT new com.xhm.unipz.fshk.department.dto.DepartmentDTO(d.departmentId, d.departmentEmri, d.departmentPershkrimi) " +
            "FROM Department d ")
    List<DepartmentDTO> findAllDepartmentsDTO();
}
