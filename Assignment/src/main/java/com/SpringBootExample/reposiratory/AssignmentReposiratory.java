package com.SpringBootExample.reposiratory;



import com.SpringBootExample.model.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AssignmentReposiratory extends JpaRepository<Assignment, Long> {

}
