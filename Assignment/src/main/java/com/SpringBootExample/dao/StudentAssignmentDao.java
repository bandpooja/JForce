package com.SpringBootExample.dao;

import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootExample.model.Assignment;
import com.SpringBootExample.model.Student;
import com.SpringBootExample.reposiratory.AssignmentReposiratory;
import com.SpringBootExample.reposiratory.StudentRepository;
@Service
public class StudentAssignmentDao {
	
	@Autowired
	AssignmentReposiratory assignrepo;
	
	@Autowired
	StudentRepository sturepo;
	
	/*to save a assignment*/
	
	public Assignment save(Assignment assign)
	{
		return assignrepo.save(assign);
	}
	
	public Student savestudent(Student student)
	{
		return sturepo.save(student);
	}
	
	/*to search all assignments*/
	public List<Assignment> findall()
	{
		return assignrepo.findAll();
	}
	
	public List<Student> findallstu()
	{
		return sturepo.findAll();
	}
	
	
	/*to search assignment by id */
	
	public Assignment findassign(Long id)
	{
		return assignrepo.findOne(id);
	}
	
	public Student findStudent(Long id)
	{
		return sturepo.findOne(id);
	}
	
	
	
	/*delete assignment*/
	
	public void deleteassign(Assignment assign)
	{
		 assignrepo.delete(assign);
	}
	
	
	
	
	}

