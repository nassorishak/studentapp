package com.registration.StudentRegistration.controller;

import com.registration.StudentRegistration.model.Course;
import com.registration.StudentRegistration.model.Registrees;
import com.registration.StudentRegistration.repository.CourseRepository;
import com.registration.StudentRegistration.repository.RegistreesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/all")

public class RegistreesAPI {
    @Autowired
    public RegistreesRepository registreesRepository;
    @GetMapping("/allRegistrees")
    public ResponseEntity<?> getRegistrees(){
        try {
            List<Registrees> RegistreesList = registreesRepository.findAll();
            if (RegistreesList.isEmpty()){
                return  new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);
            }else {
                return  new ResponseEntity<>(RegistreesList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/add")
    public  ResponseEntity<?> addRegistrees(@RequestBody Registrees Registrees){
        try {
            Registrees Registrees1 = registreesRepository.save(Registrees);
            return  new ResponseEntity<>("dataSuccess",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{RegistreesID}")
    public  ResponseEntity<?> deleted(@PathVariable int RegistreesID){
        try {
            registreesRepository.deleteById(RegistreesID);
            return  new ResponseEntity<>("data is Success",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("no data",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update{Registrees}")
    public  ResponseEntity<?> updateRegistrees(@PathVariable int RegistreesID,@RequestBody Registrees registrees){
        try {
            if (registreesRepository.findById(RegistreesID).isPresent()){
                Registrees registrees1 = registreesRepository.save(registrees);
                return  new ResponseEntity<>("data id updated",HttpStatus.BAD_REQUEST);
            }else {
                return  new ResponseEntity<>("data id not updated",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("no data updated",HttpStatus.BAD_REQUEST);
        }
    }
}
