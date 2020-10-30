package com.amplify.schoolapp.controllers;

import com.amplify.schoolapp.exceptions.StudentNotFoundException;
import com.amplify.schoolapp.models.Student;
import com.amplify.schoolapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> list(){

        List<Student> list = studentService.listStudents();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Student> get(@PathVariable Long id){

        try {
            return new ResponseEntity<Student>(studentService.findStudent(id), HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody final Student student){


        try {
            Student s = studentService.createStudent(student);
            return new ResponseEntity<Student>(s, HttpStatus.OK);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){

        try {
            Student s = studentService.updateStudent(id, student);
            return new ResponseEntity<Student>(s, HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
        }
    }
}
