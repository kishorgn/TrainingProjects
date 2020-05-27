package com.ignite.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	int id;
	String name;
	Date dob ;
	int deptno;
	double bsal;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String strDob, int deptno, double bsal) throws ParseException {
		super();
//		this.id = id;
		this.name = name;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		this.dob = df.parse(strDob);
		this.deptno = deptno;
		this.bsal = bsal;
	}
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
	public String getDob() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(this.dob);
	}
	public void setDob(String strDob) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		this.dob = df.parse(strDob);
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public double getBsal() {
		return bsal;
	}
	public void setBsal(double bsal) {
		this.bsal = bsal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", deptno=" + deptno + ", bsal=" + bsal + "]";
	}
	public String toCSV() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return id+", "+name+", "+df.format(dob)+", "+deptno+", "+bsal ;
	}
	public Employee parseEmployee(String csv) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String[] values = csv.split(",");
//		int id = Integer.parseInt(values[0].trim());
		String name = values[0].trim();
		String dob = values[1].trim();
		int deptno = Integer.parseInt(values[2].trim());
		double bsal = Double.parseDouble(values[3].trim());
		Employee employee = new Employee(name, dob, deptno, bsal);
		return employee;
	}
	
	
}
