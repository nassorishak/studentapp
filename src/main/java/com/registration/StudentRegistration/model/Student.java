package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int StudentID;
    @Column(name="StudentName")
    public String StudentName;
    @Column(name="StudentEmail")
    public String StudentEmail;
    @Column(name="StudentGender")
    public String StudentGender;
    @Column(name="StudentAddress")
    public String StudentAddress;
    @Column(name="StudentPhoneNumber")
    public int StudentPhoneNumber;
    @Column(name="CourseID")
    public   int CourseID;

//    @ManyToOne
//    @JoinColumn(name="RegistrarID")
//    public Registrar registrar;
}
