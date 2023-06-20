package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentID;
    @Column(name="StudentName")
    private String StudentName;
    @Column(name="StudentEmail")
    private String StudentEmail;
    @Column(name="StudentGender")
    private String StudentGender;
    @Column(name="StudentAddress")
    private String StudentAddress;
    @Column(name="StudentPhoneNumber")
    private int studentPhoneNumber;
}
