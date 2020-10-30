package com.amplify.schoolapp.repositories;

import com.amplify.schoolapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
