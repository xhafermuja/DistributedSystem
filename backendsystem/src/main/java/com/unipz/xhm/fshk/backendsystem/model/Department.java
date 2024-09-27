package com.unipz.xhm.fshk.backendsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String departmentEmri;
    private String departmentPershkrimi;

    @ManyToMany(mappedBy = "departmentList")
    @JsonIgnore
    private List<Professor> professorList;
    @OneToMany(mappedBy = "department")
    @JsonManagedReference("department-lenda")
    private List<Lenda> lendaList;

    public Department() {
    }

    public Department(String departmentEmri, String departmentPershkrimi) {
        this.departmentEmri = departmentEmri;
        this.departmentPershkrimi = departmentPershkrimi;
    }

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

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Lenda> getLendaList() {
        return lendaList;
    }

    public void setLendaList(List<Lenda> lendaList) {
        this.lendaList = lendaList;
    }
}
