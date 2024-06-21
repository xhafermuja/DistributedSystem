package com.unipz.xhm.fshkfrontend.model;


import com.unipz.xhm.fshkfrontend.model.Department;
import com.unipz.xhm.fshkfrontend.model.Professor;
import com.unipz.xhm.fshkfrontend.model.Semester;

import java.util.List;


public class Lenda {

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

    public Lenda() {}

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
}
