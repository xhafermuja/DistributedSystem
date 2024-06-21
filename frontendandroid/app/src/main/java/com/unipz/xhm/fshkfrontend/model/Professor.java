package com.unipz.xhm.fshkfrontend.model;



import java.util.List;


public class Professor {

    private int professorId;
    private String professorEmri;
    private int professorNrZyre;
    private int professorKati;
    private String professorEmail;
    private String professorOrariKonsultime;

    private List<Lenda> lendetLigj;

    private List<Department> departmentList;

    public Professor() {
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorEmri() {
        return professorEmri;
    }

    public void setProfessorEmri(String professorEmri) {
        this.professorEmri = professorEmri;
    }

    public int getProfessorNrZyre() {
        return professorNrZyre;
    }

    public void setProfessorNrZyre(int professorNrZyre) {
        this.professorNrZyre = professorNrZyre;
    }

    public int getProfessorKati() {
        return professorKati;
    }

    public void setProfessorKati(int professorKati) {
        this.professorKati = professorKati;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public String getProfessorOrariKonsultime() {
        return professorOrariKonsultime;
    }

    public void setProfessorOrariKonsultime(String professorOrariKonsultime) {
        this.professorOrariKonsultime = professorOrariKonsultime;
    }

    public List<Lenda> getLendetLigj() {
        return lendetLigj;
    }

    public void setLendetLigj(List<Lenda> lendetLigj) {
        this.lendetLigj = lendetLigj;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartment(Department departmentList) {
        this.departmentList.add(departmentList);
    }
}
