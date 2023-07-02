package com.registration.StudentRegistration.controller;

import com.registration.StudentRegistration.model.Registrar;
import com.registration.StudentRegistration.repository.RegistrarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all")
public class RegistrarAPI {
    @Autowired
    public RegistrarRepository registrarRepository;
    @GetMapping("/allRegistrar")
    public ResponseEntity<?> getRegistrar(){
        try {
            List<Registrar> RegistrarList = registrarRepository.findAll();
            if (RegistrarList.isEmpty()){
                return new ResponseEntity<>("no value", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(RegistrarList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/create")
    public  ResponseEntity<?> addRegistrar(@RequestBody Registrar Registrar){
        try {
            Registrar Registrar1 = registrarRepository.save(Registrar);
            return new ResponseEntity<>("data is Ok",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("no data",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{RegistrarID}")
    public ResponseEntity<?> deleted(@PathVariable int RegistrarID){
        try {
            registrarRepository.deleteById(RegistrarID);
            return  new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("no data",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update{Registrar}")
    public  ResponseEntity<?> updateRegistrar(@PathVariable int RegistrarID,@RequestBody Registrar registrar){
        try {
            if (registrarRepository.findById(RegistrarID).isPresent()){
                Registrar registrar1 = registrarRepository.save(registrar);
                return new ResponseEntity<>("data is updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("data is not updated",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("UnSuccess",HttpStatus.BAD_REQUEST);
        }
    }
}
