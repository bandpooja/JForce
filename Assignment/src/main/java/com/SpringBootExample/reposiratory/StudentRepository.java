package com.SpringBootExample.reposiratory;

import org.springframework.data.jpa.repository.JpaRepository;


import com.SpringBootExample.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
