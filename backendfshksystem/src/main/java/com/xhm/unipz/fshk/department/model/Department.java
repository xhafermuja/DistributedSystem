package com.xhm.unipz.fshk.department.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String departmentEmri;
    private String departmentPershkrimi;

    @ManyToMany(mappedBy = "department")
    private List<Professor> professorList;
    @OneToMany(mappedBy = "department")
    private List<Lenda> lendaList;
    @OneToMany(mappedBy = "department")
    private List<Semester>semesterList;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentEmri() {
        return departmentEmri;
    }

    public void setDepartmentEmri(String departmentEmri) {
        this.departmentEmri = departmentEmri;
    }

    public String getDepartmentPershkrimi() {
        return departmentPershkrimi;
    }

    public void setDepartmentPershkrimi(String departmentPershkrimi) {
        this.departmentPershkrimi = departmentPershkrimi;
    }

}
