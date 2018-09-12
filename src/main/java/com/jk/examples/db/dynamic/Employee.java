package com.jk.examples.db.dynamic;

public class Employee {
	int id;
	String name;
	String email;
	double salary;
	
	public static Employee create() {
		return new Employee();
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Employee id(int id) {
		setId(id);
		return this;
	}

	public Employee name(String name) {
		setName(name);
		return this;
	}

	public Employee salary(double salary) {
		setSalary(salary);
		return this;
	}

	public Employee email(String email) {
		setEmail(email);
		return this;
	}
}
