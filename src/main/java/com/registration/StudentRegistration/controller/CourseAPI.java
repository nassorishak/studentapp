package com.registration.StudentRegistration.controller;

import com.registration.StudentRegistration.model.Course;
import com.registration.StudentRegistration.repository.CourseRepository;
import com.registration.StudentRegistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.List;

@RestController
@RequestMapping("/all")

public class CourseAPI {
    @Autowired
    public CourseRepository courseRepository;
    @GetMapping("/allCourse")
    public ResponseEntity<?> getCourse(){
        try {
            List<Course> CourseList = courseRepository.findAll();
            if (CourseList.isEmpty()){
                return  new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);
            }else {
                return  new ResponseEntity<>(CourseList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("data is UnSuccess",HttpStatus.BAD_REQUEST);
        }
    }
  @PostMapping("/add")
    public  ResponseEntity<?> addCourse(@RequestBody Course Course){
      try {
          Course Course1 = courseRepository.save(Course);
          return  new ResponseEntity<>("success",HttpStatus.OK);
      }catch (Exception exception){
          return  new ResponseEntity<>("data UnSuccess",HttpStatus.BAD_REQUEST);
      }
  }
  @DeleteMapping("/delete{CourseID}")
    public ResponseEntity<?>  deleted(@PathVariable int CourseID){
        try {
            courseRepository.deleteById(CourseID);
            return new ResponseEntity<>("data success",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("no Data",HttpStatus.BAD_REQUEST);
        }
  }
  @PutMapping("/update{CourseID}")
    public  ResponseEntity<?> updateCourse(@PathVariable int CourseID,@RequestBody Course course){
        try {
            if (courseRepository.findById(CourseID).isPresent()){
                Course course1 = courseRepository.save(course);
                return  new ResponseEntity<>("data is updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("data not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("data is unUpdated",HttpStatus.BAD_REQUEST);
        }
  }
}
