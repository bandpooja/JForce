package com.SpringBootExample.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sid;
	
	@Column
	private String studentname;
	
	@Column
	@ElementCollection
	private List<Long> assignmentid;
	
	

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	

	public List<Long> getAssignmentid() {
		return assignmentid;
	}

	public void setAssignmentid(List<Long> assignmentid) {
		this.assignmentid = assignmentid;
	}

	

	
	
	
	
	
	
}
