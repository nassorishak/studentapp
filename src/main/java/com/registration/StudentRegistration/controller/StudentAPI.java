//package com.registration.StudentRegistration.controller;
//
//import com.registration.StudentRegistration.model.Student;
//import com.registration.StudentRegistration.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.BAD_REQUEST;
//
//@RestController
//@RequestMapping("/all")
//public class StudentAPI {
//    @Autowired
//    public StudentRepository studentRepository;
//    @GetMapping("/allStudent")
//    public  ResponseEntity<?> getStudent(){
//        try {
//            List<Student> StudentList=studentRepository.findAll();
//            if (StudentList.isEmpty()){
//                return new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);
//
//            }else {
//                return new ResponseEntity<>(StudentList,HttpStatus.OK);
//            }
//        }catch (Exception exception){
//            return new ResponseEntity<>("data UnSuccess", BAD_REQUEST);
//        }
//    }
//    @PostMapping("/addStudent")
//    public ResponseEntity<?> addStudent(@RequestBody Student student){
//        try {
//            Student student1 =  studentRepository.save(student);
//            return  new ResponseEntity<>("data success",HttpStatus.OK);
//        }catch (Exception exception){
//            return  new ResponseEntity<>("data is UnSuccess", BAD_REQUEST);
//        }
//    }
//    @DeleteMapping("/delete{StudentID}")
//    public  ResponseEntity<?> deleted(@PathVariable int StudentID){
//        studentRepository.deleteById(StudentID);
//        return  new ResponseEntity<>("Success",HttpStatus.OK);
//    }catch(Exception exception){
//        return new ResponseEntity<>("no data", BAD_REQUEST)
//    }
//}
package com.registration.StudentRegistration.controller;

import com.registration.StudentRegistration.model.Student;
import com.registration.StudentRegistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/all")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAPI {
    @Autowired
    public StudentRepository studentRepository;
    @GetMapping("/allStudent")
    public  ResponseEntity<?> getStudent(){
        try {
            List<Student> StudentList=studentRepository.findAll();
            if (StudentList.isEmpty()){
                return new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);

            }else {
                return new ResponseEntity<>(StudentList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("data UnSuccess", BAD_REQUEST);
        }
    }
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        try {
            Student student1 =  studentRepository.save(student);
            return  new ResponseEntity<>("data success",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess", BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete/{StudentID}")
    public  ResponseEntity<?> deleted(@PathVariable int StudentID){
        try {
            studentRepository.deleteById(StudentID);
            return new ResponseEntity<>("Success",HttpStatus.OK);
    }catch (Exception exception){
            return  new ResponseEntity<>("data UnSuccess", BAD_REQUEST);
        }
}

    @PutMapping("/update/{StudentID}")
    public ResponseEntity<?> updateStudent(@PathVariable int StudentID, @RequestBody Student student){
        try {
            if(studentRepository.findById(StudentID).isPresent()){
                Student student1 = studentRepository.save(student);
                return new ResponseEntity<>("Updated SuccessFull", HttpStatus.OK);

            }else {
                return new ResponseEntity<>("Student Not Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network Error", BAD_REQUEST);
        }
    }


    @GetMapping("/byId/{StudentID}")
    public ResponseEntity<?> getByID(@PathVariable int StudentID){
        try {
            Optional<Student> optionalStudent = studentRepository.findById(StudentID);

            if(optionalStudent.isPresent()){
                return new ResponseEntity<>(optionalStudent, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network Error", HttpStatus.CONFLICT);
        }
    }
}
