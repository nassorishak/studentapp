package com.registration.StudentRegistration.controller;

import com.registration.StudentRegistration.model.Requirement;
import com.registration.StudentRegistration.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all")
public class RequirementAPI {
    @Autowired
    public RequirementRepository requirementRepository;
    @GetMapping("/allRequirement")
    public ResponseEntity<?> getRequirement(){
        try {
            List<Requirement> RequirementList = requirementRepository.findAll();
            if (RequirementList.isEmpty()){
                return  new ResponseEntity<>("no  data", HttpStatus.NOT_FOUND);
            }else {
                return  new ResponseEntity<>(RequirementList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping("/addRequirement")
    public  ResponseEntity<?> addRequirement(@RequestBody Requirement Requirement){
       try {
           Requirement Requirement1 = requirementRepository.save(Requirement);
           return  new ResponseEntity<>("dataSuccess",HttpStatus.OK);
       }catch (Exception exception){
           return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
       }
    }
    @DeleteMapping("/delete{Requirement}")
    public ResponseEntity<?> deleted(@PathVariable int RequirementID){
        try {
             requirementRepository.deleteById(RequirementID);
             return  new ResponseEntity<>("no data",HttpStatus.OK);
        }catch(Exception exception){
            return  new ResponseEntity<>("Success",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{RequirementID}")
    public ResponseEntity<?> updateRequirement(@PathVariable int RequirementID,@RequestBody Requirement requirement){
        try {
            if (requirementRepository.findById(RequirementID).isPresent()){
                Requirement requirement1 = requirementRepository.save(requirement);
                return  new ResponseEntity<>("data updated",HttpStatus.OK);

            }else {
                return  new ResponseEntity<>("data not updated",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("wrong data",HttpStatus.BAD_REQUEST);
        }
    }
}
