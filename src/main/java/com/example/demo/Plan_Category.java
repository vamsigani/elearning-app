package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import lombok.Data;


@Data
@Entity
@Table(name = "PLAN_CATEGORY")
public class Plan_Category {
	
	

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue
	private Integer CategoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String CategoryName;
	
	@Column(name = "ACTIVE_SW")
	private String Active_Sw;
	
	@Column(name = "CREATE_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate CreateDate;
	@Column(name = "UPDATE_DATE",insertable=false )
	private LocalDate UpdateDate;
	@Column(name = "CREATED_BY")
	private String Created_by;
	@Column(name = "UPDATED_BY")
	private String Update_by;
}
