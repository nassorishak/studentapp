package com.registration.StudentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Registrees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RegistreesID;
    @Column(name="RegistreesName")
    private  String RegistreesName;
    @Column(name="RegistreesEmail")
    private String RegistreesEmail;
    @Column(name="RegistreesGender")
    private String RegistreesGender;
    @Column(name="RegistreesAddress")
    private String RegistreesAddress;
    @Column(name="RegistreesPhoneNumber")
    private int RegistreesPhoneNumber;
}
