/*
 * Copyright 2002-2016 Jalal Kiswani.
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
package com.jk.db.examples;

import java.util.List;

import com.jk.db.dataaccess.plain.JKPlainDataAccess;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.db.examples.beans.Employee;
import com.jk.util.JK;

/**
 * Test plain CRUD Operations.
 *
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDbExample1 {
	static final int EMP_ID = 1050;
	static JKPlainDataAccess plainDataAccess = JKDataSourceFactory.getPlainDataAccess();

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		clearEmployeesTable();
		getAllEmployeeRecords();
		insertEmployeeRecord();
		getAllEmployeeRecords();
		updateEmployeeRecord();
		getAllEmployeeRecords();
		deleteEmployeeRecord();
		getAllEmployeeRecords();
	}

	/**
	 * Clear employees table.
	 */
	public static void clearEmployeesTable() {
		plainDataAccess.execute("DELETE FROM hr_employees");
		JK.print("Employees table cleared succ...");
	}

	/**
	 * Gets the all employee records.
	 *
	 * @return the all employee records
	 */
	public static void getAllEmployeeRecords() {
		// get all employees with salary more than 10
		List<Employee> list = plainDataAccess.executeQueryAsObjectList(Employee.class, "id,name,salary",
				"SELECT emp_id,emp_name,emp_salary FROM hr_employees WHERE emp_salary>?", 100);
		if (list.size() == 0) {
			JK.print("NO employees found..");
			return;
		}
		for (Employee employee : list) {
			JK.print(employee);
		}
	}

	/**
	 * Insert employee record.
	 */
	public static void insertEmployeeRecord() {
		plainDataAccess.execute("INSERT INTO hr_employees (emp_id,dep_id,emp_name,emp_salary) VALUES(?,?,?,?)", EMP_ID, 1, "Jalal", 1000);
		JK.print("Record Added Success");
	}

	/**
	 * Update employee record.
	 */
	public static void updateEmployeeRecord() {
		plainDataAccess.execute("UPDATE hr_employees SET emp_salary=? WHERE emp_id=?", 2222, EMP_ID);
		JK.print("Updated succ...");
	}

	/**
	 * Delete employee record.
	 */
	public static void deleteEmployeeRecord() {
		plainDataAccess.execute("DELETE FROM hr_employees WHERE emp_id=?", EMP_ID);
		JK.print("Deleted succ...");
	}
}
