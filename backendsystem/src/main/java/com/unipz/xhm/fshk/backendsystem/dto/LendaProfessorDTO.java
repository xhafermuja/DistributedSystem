package com.unipz.xhm.fshk.backendsystem.dto;

public class LendaProfessorDTO {
    private int lendaId;
    private String lendaTitulli;
    private int lendaKredi;
    private String lendaOraMbajtjes;
    private int professorId;
    private String professorEmri;
    private int professorNrZyre;
    private int professorKati;
    private String professorEmail;
    private String professorOrariKonsultime;
    private int semesterId;
    private int departmentId;

    public LendaProfessorDTO(int lendaId, String lendaTitulli, int lendaKredi,
                             String lendaOraMbajtjes, int professorId, String professorEmri,
                             int professorNrZyre, int professorKati, String professorEmail,
                             String professorOrariKonsultime, int semesterId, int departmentId) {
        this.lendaId = lendaId;
        this.lendaTitulli = lendaTitulli;
        this.lendaKredi = lendaKredi;
        this.lendaOraMbajtjes = lendaOraMbajtjes;
        this.professorId = professorId;
        this.professorEmri = professorEmri;
        this.professorNrZyre = professorNrZyre;
        this.professorKati = professorKati;
        this.professorEmail = professorEmail;
        this.professorOrariKonsultime = professorOrariKonsultime;
        this.semesterId = semesterId;
        this.departmentId = departmentId;
    }


    public int getLendaId() {
        return lendaId;
    }

    public void setLendaId(int lendaId) {
        this.lendaId = lendaId;
    }

    public String getLendaTitulli() {
        return lendaTitulli;
    }

    public void setLendaTitulli(String lendaTitulli) {
        this.lendaTitulli = lendaTitulli;
    }

    public int getLendaKredi() {
        return lendaKredi;
    }

    public void setLendaKredi(int lendaKredi) {
        this.lendaKredi = lendaKredi;
    }

    public String getLendaOraMbajtjes() {
        return lendaOraMbajtjes;
    }

    public void setLendaOraMbajtjes(String lendaOraMbajtjes) {
        this.lendaOraMbajtjes = lendaOraMbajtjes;
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

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
