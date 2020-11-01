package com.SpringBootExample.controller;

import java.nio.file.AccessDeniedException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootExample.Exception.AccessDeniedExceptiontosite;
import com.SpringBootExample.Exception.Nosubmiision;
import com.SpringBootExample.dao.StudentAssignmentDao;
import com.SpringBootExample.model.Assignment;
import com.SpringBootExample.model.Student;

@RestController
@RequestMapping("/college")
public class AssignmentController {
	
	@Autowired
	StudentAssignmentDao dao;
	
	//save assignment
	@PostMapping("/Assignment/{type}")
	public Assignment createassignment(@Valid @RequestBody Assignment assign,@PathVariable(value="type")String type) throws AccessDeniedExceptiontosite {
		if(type.equals("Faculty"))
		{
		return dao.save(assign);
		}
		else
			throw  new AccessDeniedExceptiontosite();
			
		
	}
	
	//get all assignemnt 
	
	@GetMapping("/Assignment")
	public List<Assignment> getAllAssignment() throws ParseException
	{
		List<Assignment> list=dao.findall();
		
		List<Assignment> runningassignmnets=new ArrayList<Assignment>();
		Date d1 = new Date();
		for(Assignment a:list) {
			Date d2=new SimpleDateFormat("dd/MM/yy").parse(a.getEndDate());
			if(d2.compareTo(d1)>0)
			{
				runningassignmnets.add(a);
			}
			
			
		}
		return runningassignmnets;
		 
	}
	
	@GetMapping("/Assignment/{id}")
	public ResponseEntity<Assignment> getAssignmentbyID(@PathVariable(value="id")Long assignid)
	{
		Assignment a=dao.findassign(assignid);
		if(a==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(a);
	}
	
	@PutMapping("Assignment/{type}/{id}")
	public ResponseEntity<Assignment> updateassignment(@PathVariable(value="id")Long assignid,@Valid @RequestBody Assignment assign,@PathVariable(value="type")String type) throws AccessDeniedExceptiontosite
	{
if(type.equals("Faculty"))
{
		Assignment a= dao.findassign(assignid);
		if(a==null)
		{
			return ResponseEntity.notFound().build();
			
		}
		a.setAname(assign.getAname());
		a.setStartDate(assign.getStartDate());
		a.setEndDate(assign.getEndDate());
		
		Assignment updateassign =dao.save(a);
		return ResponseEntity.ok().body(updateassign);
}
else
	throw new AccessDeniedExceptiontosite();
	}
	
	@DeleteMapping("Assignment/{type}/{id}")
	public ResponseEntity<Assignment> deleteassignment(@PathVariable(value="id")Long assignid,@PathVariable(value="type")String type) throws AccessDeniedExceptiontosite
	{
		if(type.equals("Faculty"))
		{
		Assignment a=dao.findassign(assignid);
		if(a==null)
		{
			return ResponseEntity.notFound().build();
		}
		dao.deleteassign(a);
		return ResponseEntity.ok().build();
		}
		else
			throw new AccessDeniedExceptiontosite();
	}
	
	@PostMapping("/Student")
	public Student createstudent(@Valid @RequestBody Student student)
	{
		return dao.savestudent(student);
		
	}
	
	
	@PutMapping("Student/{id}")
	public ResponseEntity<Student> updatestudent(@PathVariable(value="id")Long stuid,@Valid @RequestBody Student student) throws ParseException, Nosubmiision
	{
		Student a= dao.findStudent(stuid);
		if(a==null)
		{
			return ResponseEntity.notFound().build();
			
		}
		
	    Date d1 = new Date(); 
	    
	    List<Long> list=new ArrayList<Long>();
	    list=student.getAssignmentid();
	    
	    List<Assignment> assignmentlist=new ArrayList<Assignment>();
	    for(Long id: list)
	    {
	    	assignmentlist.add(dao.findassign(id));
	    }
		
	    for (Assignment a1 : assignmentlist) {
	    	Date d2=new SimpleDateFormat("dd/MM/yy").parse(a1.getEndDate()); 
	    	if(d1.compareTo(d2)>0)
		    {
		    throw new Nosubmiision();	
		    }
	    	else
	    		a.setAssignmentid(student.getAssignmentid());
		    
	        }
	    
	    
	    
	    
	    
	    
	   
	    
		a.setStudentname(student.getStudentname());
		
		
		
		Student updatestudent =dao.savestudent(a);
		
		return ResponseEntity.ok().body(updatestudent);
	    }

	@GetMapping("/Student/{type}")
	public List<Student> getAllstudent(@PathVariable(value="type")Long type) throws AccessDeniedExceptiontosite{
		
		if(type.equals("admin"))
				{
		return dao.findallstu();
				}
		else
		{
			throw new AccessDeniedExceptiontosite();
		}
	}
		
		@GetMapping("/{type}")
		public List<Assignment> getAllassignmentadmin(@PathVariable(value="type")Long type) throws AccessDeniedExceptiontosite{
			
			if(type.equals("admin"))
					{
			return dao.findall();
					}
			else
			{
				throw new AccessDeniedExceptiontosite();
			}
	}
	
	
	
	
}
