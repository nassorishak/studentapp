package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int CourseID;
    @Column(name="CourseName")
    private String CourseName;
    @Column(name="CourseTitle")
    private String CourseTitle;
    @Column(name="CourseCode")
    private int CourseCode;
    @Column(name="CourseGrade")
    private  int CourseGrade;
    private  int RegistreesID;

    @ManyToOne
    @JoinColumn(name="RegistrarID")
    private Registrar registrar;

    @ManyToOne
    @JoinColumn(name="RequirementID")
    private Requirement requirement;


}
