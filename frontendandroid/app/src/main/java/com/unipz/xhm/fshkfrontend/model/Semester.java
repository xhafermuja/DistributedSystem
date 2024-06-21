package com.unipz.xhm.fshkfrontend.model;



import java.util.List;


public class Semester {

    private int semesterId;

    private String semesterTitulli;


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
