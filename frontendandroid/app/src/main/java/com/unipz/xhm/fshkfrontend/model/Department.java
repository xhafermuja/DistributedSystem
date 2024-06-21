package com.unipz.xhm.fshkfrontend.model;


import java.util.List;

public class Department {

    private int departmentId;
    private String departmentEmri;
    private String departmentPershkrimi;
    private List<Professor> professorList;

    private List<Lenda> lendaList;

    public Department(){}

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
