package com.amplify.schoolapp.services;

import com.amplify.schoolapp.exceptions.StudentNotFoundException;
import com.amplify.schoolapp.models.Student;
import com.amplify.schoolapp.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> listStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findStudent(Long id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new StudentNotFoundException("Student Not Found");
        }
    }

    @Override
    public Student createStudent(Student student) throws Exception {

        try {
            return studentRepository.saveAndFlush(student);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            BeanUtils.copyProperties(student, existingStudent, "student_id");
            studentRepository.saveAndFlush(existingStudent);
            return existingStudent;
        } else {
            throw new StudentNotFoundException("Student Not Found");
        }
    }

    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException("Student Not Found");
        }
    }
}
