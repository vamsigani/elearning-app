
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
@Table(name = "PLAN_MASTER")
public class Plan {

	@Id

	@Column(name = "PLAN_ID")

	@GeneratedValue
	private Integer PLAN_ID;

	@Column(name = "PLAN_NAME")
	private String PLAN_NAME;

	@Column(name = "PLAN_START_DATE")
	private LocalDate PLAN_START_DATE;

	@Column(name = "PLAN_END_DATE")
	private LocalDate PLAN_END_DATE;

	@Column(name = "ACTIVE_SW")
	private String Active_Sw;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer PLAN_CATEGORY_ID;

	@Column(name = "CREATE_DATE", updatable = false)

	@CreationTimestamp
	private LocalDate CreateDate;

	@CreationTimestamp
    @Column(name = "UPDATE_DATE", insertable = false)
	private LocalDate UpdateDate;

	@Column(name = "CREATED_BY")
	private String Created_by;

	@Column(name = "UPDATED_BY")
	private String Update_by;

}
