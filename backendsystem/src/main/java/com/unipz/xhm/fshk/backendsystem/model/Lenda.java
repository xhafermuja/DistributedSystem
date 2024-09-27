package com.unipz.xhm.fshk.backendsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Lenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lendaId;
    private String lendaTitulli;
    private int lendaKredi;
    private String lendaOraMbajtjes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id",referencedColumnName = "professorId")
    @JsonBackReference("professor-lenda")
    private Professor ligjeruesi;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="semester_id", referencedColumnName = "semesterId")
    @JsonBackReference("semester-lenda")
    private Semester semester;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id", referencedColumnName = "departmentId")
    @JsonBackReference("department-lenda")
    private Department department;


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

    public Professor getLigjeruesi() {
        return ligjeruesi;
    }

    public void setLigjeruesi(Professor ligjeruesi) {
        this.ligjeruesi = ligjeruesi;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
