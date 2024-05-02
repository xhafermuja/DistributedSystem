package com.xhm.unipz.fshk.department.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;
    private String professorEmri;
    private int professorNrZyre;
    private int professorKati;
    private String professorEmail;
    private String professorOrariKonsultime;

    @JsonIgnore
    @OneToMany(mappedBy="ligjeruesi")
    private List<Lenda> lendetLigj;

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

}
