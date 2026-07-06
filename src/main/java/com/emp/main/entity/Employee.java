package com.emp.main.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Employee {

	@Id
	private int id;
	private String name;
	private String designation;
	private double sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name, String designation, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.sal = sal;
	}
	
	
}
