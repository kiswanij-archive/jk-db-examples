/*
 * Copyright 2002-2018 Jalal Kiswani. 
 * E-mail: Kiswani.Jalal@Gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jk.examples.db.dynamic;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The id. */
	int id;
	
	/** The name. */
	String name;
	
	/** The email. */
	String email;
	
	/** The salary. */
	Double salary;
	
	/**
	 * Creates the.
	 *
	 * @return the employee
	 */
	public static Employee create() {
		return new Employee();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * Id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	public Employee id(int id) {
		setId(id);
		return this;
	}

	/**
	 * Name.
	 *
	 * @param name the name
	 * @return the employee
	 */
	public Employee name(String name) {
		setName(name);
		return this;
	}

	/**
	 * Salary.
	 *
	 * @param salary the salary
	 * @return the employee
	 */
	public Employee salary(Double salary) {
		setSalary(salary);
		return this;
	}

	/**
	 * Email.
	 *
	 * @param email the email
	 * @return the employee
	 */
	public Employee email(String email) {
		setEmail(email);
		return this;
	}
}
