package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RequirementID;
    @Column(name="BirthCertificate")
    private String BirthCertificate;
    @Column(name="qualification")
    private  String qualification;
    @Column(name="Sub_date")
    private String Sub_date;
    @Column(name="Good_moral")
    private String Good_moral;
    @Column(name="CourseID")
    private  int CourseID;
    @Column(name="StudentID")
    private  int StudentID;
    @Column(name="RegistreesID")
    private int RegistreesID;






//    @OneToOne
//    @JoinColumn(name="RegistreesID")
//    private Registrees registrees;



}
