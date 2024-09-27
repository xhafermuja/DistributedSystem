package com.unipz.xhm.fshk.backendsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterId;

    private String semesterTitulli;

    @OneToMany(mappedBy = "semester")
    @JsonManagedReference("semester-lenda")
    private List<Lenda> lendet;

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterTitulli() {
        return semesterTitulli;
    }

    public void setSemesterTitulli(String semesterTitulli) {
        this.semesterTitulli = semesterTitulli;
    }

    public List<Lenda> getLendet() {
        return lendet;
    }

    public void setLendet(List<Lenda> lendet) {
        this.lendet = lendet;
    }



}
