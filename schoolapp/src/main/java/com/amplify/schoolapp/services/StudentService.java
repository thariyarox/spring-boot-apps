package com.amplify.schoolapp.services;

import com.amplify.schoolapp.exceptions.StudentNotFoundException;
import com.amplify.schoolapp.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> listStudents();
    Student findStudent(Long id) throws StudentNotFoundException;
    Student createStudent(Student student) throws Exception;
    Student updateStudent(Long id, Student student) throws StudentNotFoundException;
    void deleteStudent(Long id) throws StudentNotFoundException;
}
