package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Registrar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RegistrarID;
    @Column(name="RegistrarName")
    private String RegistrarName;
    @Column(name="RegistrarAge")
    private  int RegistrarAge;
    @Column(name="RegistrarGender")
    private  String RegistrarGender;
    @Column(name="RegistrarPhoneNumber")
    private  int RegistrarPhoneNumber;
    @Column(name="RegistrarEmail")
    private String RegistrarEmail;
    @Column(name="RegistrarUsername")
    private String RegistrarUsername;
    @Column(name="RegistrarPassword")
    private int RegistrarPassword;

//    @ManyToOne
//    @JoinColumn(name="RegistreesID")
//    private Registrees registrees;

}
