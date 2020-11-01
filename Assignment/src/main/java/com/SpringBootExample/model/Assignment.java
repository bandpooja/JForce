package com.SpringBootExample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Assignment")
@EntityListeners(AuditingEntityListener.class)
public class Assignment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Aid;
	
	
	@Column
	private String Aname;
	
	
	
	@Column
	private String StartDate;
	
	
	@Column
	private String EndDate;

	
	
	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public Long getAid() {
		return Aid;
	}

	public void setAid(Long aid) {
		Aid = aid;
	}

	
	
	
	
	
	
	

}
